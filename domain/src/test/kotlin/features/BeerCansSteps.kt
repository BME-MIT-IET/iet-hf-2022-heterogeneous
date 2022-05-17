package features
import io.cucumber.java8.En
import junit.framework.Assert.assertEquals

fun isItFriday(today: String) = ""

class BeerCansSteps : En {

    private lateinit var today: String
    private lateinit var actualAnswer: String
    init {
        Given("today is Sunday") {
            today = "Sunday"
        }

        When("I ask whether it's Friday yet") {
            actualAnswer = isItFriday(today)
        }
        Then("I should be told {string}") { expectedAnswer : String ->
            assertEquals(expectedAnswer, actualAnswer)
        }
    }
}