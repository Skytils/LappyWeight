package skytils.lappyweight

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import skytils.lappyweight.weightcalc.skillXPPerLevel
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

@Throws(IOException::class)
internal fun getString(urlString: String): String {
    val connection = URL(urlString).openConnection() as HttpURLConnection
    connection.requestMethod = "GET"
    connection.useCaches = true
    connection.addRequestProperty("User-Agent", "SkytilsLappyWeight/1.0.0")
    connection.readTimeout = 15000
    connection.connectTimeout = 15000
    connection.doOutput = true
    return connection.inputStream.bufferedReader(Charsets.UTF_8).readText()
}

internal fun getLevelFromXP(xp: Double): Int {
    var xpAdded = 0
    for (i in 0..61) {
        xpAdded += skillXPPerLevel[i]
        if (xp < xpAdded)
            return ((i - 1) + (xp - (xpAdded - skillXPPerLevel[i])) / skillXPPerLevel[i]).toInt()
    }

    return 60
}

internal fun getXpFromLevel(level: Int): Double = skillXPPerLevel.subList(0, level).sum().toDouble()

@Serializable
internal data class Member(
    @SerialName("slayer_bosses")
    val slayerBosses: SlayerData = SlayerData(),
    val dungeons: DungeonData = DungeonData()
)

@Serializable
internal data class SlayerData(
    val zombie: Slayer = Slayer(),
    val spider: Slayer = Slayer(),
    val wolf: Slayer = Slayer(),
    val enderman: Slayer = Slayer()
)

@Serializable
internal data class Slayer(val xp: Int = 0)

@Serializable
internal data class DungeonData(
    @SerialName("dungeon_types")
    val dungeonTypes: DungeonTypes = DungeonTypes()
)

@Serializable
internal data class DungeonTypes(
    val catacombs: DungeonStats = DungeonStats(),
    @SerialName("master_catacombs")
    val masterCatacombs: DungeonStats = DungeonStats()
)

@Serializable
internal data class DungeonStats(
    @SerialName("tier_completions")
    val tierCompletions: LinkedHashMap<String, Double> = linkedMapOf(),
    val experience: Double = 0.0
)