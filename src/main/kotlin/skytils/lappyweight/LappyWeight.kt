package skytils.lappyweight

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.*
import skytils.lappyweight.weightcalc.*

object LappyWeight {

    internal val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    @Throws(IllegalStateException::class)
    fun getWeight(apiKey: String, uuid: String, profileName: String? = null): PlayerWeight {
        @Suppress("NAME_SHADOWING")
        val uuid = uuid.replace("-", "")
        try {
            val res =
                json.decodeFromString<JsonObject>(getString("https://api.hypixel.net/skyblock/profiles?key=${apiKey}&uuid=${uuid}"))

            if (res["success"]?.jsonPrimitive?.booleanOrNull != true) error("Unsuccessful request")

            val profile = res["profiles"]?.jsonArray?.run {
                if (profileName.isNullOrBlank()) maxByOrNull {
                    it.jsonObject["members"]?.jsonObject?.get(uuid)?.jsonObject?.get("last_save")?.jsonPrimitive?.longOrNull
                        ?: 0L
                }
                else find { it.jsonObject["cute_name"]?.jsonPrimitive.toString() == profileName }
            }?.jsonObject?.get("members")?.jsonObject?.get(uuid)?.jsonObject ?: error("No Profile Found")

            json.decodeFromJsonElement<Member>(profile).apply {
                val slayerXP = listOf(
                    slayerBosses.zombie.xp,
                    slayerBosses.spider.xp,
                    slayerBosses.wolf.xp,
                    slayerBosses.enderman.xp
                )
                val cataCompl =
                    dungeons.dungeonTypes.catacombs.tierCompletions.entries.associate { it.key to it.value.toInt() }
                val mCataCompl =
                    dungeons.dungeonTypes.masterCatacombs.tierCompletions.entries.associate { it.key to it.value.toInt() }
                val cataXP = dungeons.dungeonTypes.catacombs.experience

                val isSkillAPIOn = profile.containsKey("experience_skill_mining")
                val skillLevels: List<Int>
                val skillXP: List<Double>
                if (isSkillAPIOn) {
                    skillXP = skillNames.keys.map { profile[it]?.jsonPrimitive?.double ?: 0.0 }
                    skillLevels = skillXP.map(::getLevelFromXP)
                } else {
                    val p =
                        json.decodeFromString<JsonObject>(getString("https://api.hypixel.net/player?key=${apiKey}&uuid=${uuid}"))
                    if (p["success"]?.jsonPrimitive?.booleanOrNull != true) error("Unsuccessful player request")

                    val achieve =
                        p["player"]?.jsonObject?.get("achievements")?.jsonObject ?: error("Unable to get achievements")
                    skillLevels = skillNames.values.map {
                        achieve[it]?.jsonPrimitive?.int ?: 0
                    }
                    skillXP = skillLevels.map(::getXpFromLevel)
                }
                return getWeightRaw(skillLevels, skillXP, cataCompl, mCataCompl, cataXP, slayerXP)
            }
        } catch (t: Throwable) {
            throw IllegalStateException("Caught exception while executing", t)
        }
    }

    fun getWeightRaw(
        skillLevels: List<Int>,
        skillXP: List<Double>,
        cataCompl: Map<String, Int>,
        mCataCompl: Map<String, Int>,
        cataXP: Double,
        slayerXP: List<Int>
    ): PlayerWeight {
        val (skillWeight, overflowWeight) = getSkillWeight(skillLevels, skillXP);
        val (cataComplWeight, masterCataComplWeight) = getDungeonCompletionWeight(cataCompl, mCataCompl);
        val cataExpWeight = getDungeonExpWeight(cataXP)
        val slayerWeight = getSlayerWeight(slayerXP)

        return PlayerWeight(
            total = (skillWeight + overflowWeight + cataComplWeight + masterCataComplWeight + cataExpWeight + slayerWeight),
            skill = SkillWeightPair(
                base = skillWeight,
                overflow = overflowWeight
            ),
            catacombs = DungeonWeight(
                completion = DungeonWeightPair(
                    base = cataComplWeight,
                    master = masterCataComplWeight
                ),
                experience = cataExpWeight
            ),
            slayer = slayerWeight
        )
    }

    @Serializable
    data class PlayerWeight(
        val total: Double,
        val skill: SkillWeightPair,
        val catacombs: DungeonWeight,
        val slayer: Double
    )

    @Serializable
    data class DungeonWeight(
        val completion: DungeonWeightPair,
        val experience: Double
    )

    @Serializable
    data class SkillWeightPair(val base: Double, val overflow: Double)

    @Serializable
    data class DungeonWeightPair(val base: Double, val master: Double)
}