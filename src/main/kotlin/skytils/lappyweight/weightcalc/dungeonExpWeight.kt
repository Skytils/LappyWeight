package skytils.lappyweight.weightcalc

import kotlin.math.pow

internal fun getDungeonExpWeight(cataXP: Double): Double {
    val levelNoProgress = dungeonExperienceTable.count {
        cataXP >= it
    }

    var level = levelNoProgress.toDouble()

    if (levelNoProgress != 50) {
        val nextLvlXP = (dungeonExperienceTable[levelNoProgress + 1] - dungeonExperienceTable[levelNoProgress])
        val progress = ((cataXP - dungeonExperienceTable[levelNoProgress]) / nextLvlXP * 1000).toInt() / 1000.0
        level += progress
    }

    val n: Double =
        if (cataXP < 569809640)
            0.2 * (level / 50.0).pow(2.967355422)
        else 0.2 * (1 + (((50 + (cataXP - dungeonMaxXP) / 142452410.0) - 50) / 50.0)).pow(2.967355422)

    return if (level != 0.0) {
        if (cataXP < 569809640) dungeonOverall * ((1.18340401286164044.pow((level + 1) - 1.05994990217254)) * (1 + n))
        else 4000 * (n / 0.15465244570598540)
    } else 0.0
}