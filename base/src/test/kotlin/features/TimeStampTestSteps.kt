package features
import io.cucumber.java8.En
import junit.framework.Assert.assertEquals
import sk.kasper.base.utils.toTimeStamp

fun isItFriday(today: String) = ""

class BeerCansSteps : En {

    private lateinit var today: String
    private var todayTimeStamp: Long = 1275677100000L

    private lateinit var actualAnswer: String
    init {
        Given("today is June 4") {
            today = "June 4, 2010 18:45:00 UTC"
        }
        When("I try to make it a time stamp") {
            todayTimeStamp = today.toTimeStamp();
        }
        Then("It should be 1275677100000L") {
            assertEquals(todayTimeStamp, 1275677100000L)
        }
        Given("bad value") {
            today = "Nonsense value xyz"
        }
        Then("It should be 0L") {
            assertEquals(todayTimeStamp, 0L)
        }
    }
}