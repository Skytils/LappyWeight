package skytils.lappyweight.weightcalc

import kotlin.math.ln
import kotlin.math.pow


private val max1000 = dungeonCompletionWorth.subList(0, 8).sum() * 1000
private val mMax1000 = dungeonCompletionWorth.subList(8, dungeonCompletionWorth.size).sum() * 1000


internal fun getDungeonCompletionWeight(
    cataCompl: Map<String, Int>,
    mCataCompl: Map<String, Int>
): Pair<Double, Double> {
    var upperBound = 1500.0

    val score = cataCompl.entries.sumOf {
        val floor = it.key.toInt()
        var amount = it.value

        var excess = 0
        if (amount > 1000) {
            excess = amount - 1000
            amount = 1000
        }

        amount * dungeonCompletionWorth[floor] * if (excess > 0) ln(excess / 1000.0 + 1) / ln(7.5) + 1 else 1.0
    }

    val rating = (score / max1000) * upperBound

    mCataCompl.entries.forEach { (floor, amount) ->
        if (dungeonCompletionBuffs.containsKey(floor)) {
            val threshold = 20.0
            if (amount >= threshold) upperBound += dungeonCompletionBuffs[floor]!!
            else upperBound += dungeonCompletionBuffs[floor]!! * (amount / threshold).pow(1.84089641)
        }
    }

    val masterScore = mCataCompl.entries.sumOf {
        val floor = it.key.toInt()
        var amount = it.value

        var excess = 0
        if (amount > 1000) {
            excess = amount - 1000
            amount = 1000
        }

        amount * dungeonCompletionWorth[floor + 7] * if (excess > 0) ln(excess / 1000.0 + 1) / ln(5.0) + 1 else 1.0
    }

    val masterRating = (masterScore / mMax1000) * upperBound
    return rating to masterRating
}
