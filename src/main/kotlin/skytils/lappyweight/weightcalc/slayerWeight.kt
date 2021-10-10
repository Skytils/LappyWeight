package skytils.lappyweight.weightcalc

import kotlin.math.*

internal fun getSlayerScore(exp: Int): Double {
    val d = exp / 100000.0
    return if (exp >= 6416) {
        val D = (d - 3.0.pow((-5 / 2.0))) * (d + 3.0.pow(-5 / 2.0))
        val u = (3 * (d + sqrt(D))).pow(1 / 3.0)
        val v = (3 * (d - sqrt(D))).pow(1 / 3.0)
        u + v - 1
    } else {
        sqrt(4 / 3.0) * cos(acos(d * 3.0.pow(5 / 2.0)) / 3.0) - 1
    }
}

internal fun getEffectiveXP(score: Double, ind: Int): Int {
    val scaling = slayerDeprecationScaling[ind]
    var total = 0.0
    for (i in 1..score.roundToInt().inc()) {
        val d = i.toDouble()
        total += (d.pow(2) + i) * scaling.pow(d)
    }

    return (((1000000 * total * (0.05 / scaling)) * 100) / 100.0).roundToInt()
}

internal fun getActualXP(score: Double) = ((score.pow(3) / 6.0) + (score.pow(2) / 2.0) + (score / 3.0)) * 100000

internal fun getSlayerValue(xp: Int, i: Int): Double {
    val score = floor(getSlayerScore(xp))
    val effectiveXP = getEffectiveXP(score, i)
    val actualXP = getActualXP(score)
    val distance = xp - actualXP
    val effectiveDistance = distance * slayerDeprecationScaling[i].pow(score)
    return effectiveXP + effectiveDistance
}

internal fun getSlayerWeight(slayerXP: List<Int>): Double {
    val zombie = getSlayerValue(slayerXP[0], 0)
    val spider = getSlayerValue(slayerXP[1], 1)
    val wolf = getSlayerValue(slayerXP[2], 2)
    val enderman = getSlayerValue(slayerXP[3], 3)

    val individual = zombie / 7000.0 + spider / 4800.0 + wolf / 2200.0 + enderman / 1000.0
    val extra = (slayerXP[0] + 1.6 * slayerXP[1] + 3.6 * slayerXP[2] + 10 * slayerXP[3]) / 900000.0
    return (individual + extra)
}