import skytils.lappyweight.LappyWeight
import kotlin.test.Test

class LappyWeightTest {
    @Test
    fun getWeight() {
        val apiKey = System.getenv("APIKEY")

        println(
            LappyWeight.getWeight(apiKey, "baf721927e1b45a2a80e2e873bdbbacf")
        )
    }
}