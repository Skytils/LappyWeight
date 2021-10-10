package skytils.lappyweight.weightcalc

import kotlin.math.pow
import kotlin.math.sqrt

private fun effectiveXP(xp: Double, factor: Double): Double {
    return if (xp < skillMaxXP)
        xp
    else {
        var remainingXP = xp
        var z = 0.0
        for (i in 0..(xp / skillMaxXP).toInt()) {
            if (remainingXP >= skillMaxXP) {
                remainingXP -= skillMaxXP
                z += factor.pow(i)
            }
        }
        (z * skillMaxXP)
    }
}

internal fun getSkillWeight(skillLevels: List<Int>, skillXP: List<Double>): Pair<Double, Double> {
    val skillAvg = skillLevels.sum() / skillLevels.size

    val n = 12 * ((skillAvg / 60.0).pow(2.0))
    val r2 = sqrt(2.0)

    val skillRating = skillLevels.mapIndexed { i, it ->
        val skill = skillRatioWeight[i]
        n * skill.second[it] * skill.second.last() +
                skill.second.last() * (it / 60.0).pow(r2)
    }.sum()

    val overflowRating = skillXP.filter { it > skillMaxXP }.mapIndexedNotNull { i, it ->
        val factor = skillFactors[i]
        val effectiveOver = effectiveXP(it - skillMaxXP, factor)
        val rating = effectiveOver / skillMaxXP
        val overflowMult = skillOverflowMultipliers[i]
        val t = rating * overflowMult
        if (t > 0)
            (rating * overflowMult)
        else null
    }.sum()

    return skillRating to overflowRating
}