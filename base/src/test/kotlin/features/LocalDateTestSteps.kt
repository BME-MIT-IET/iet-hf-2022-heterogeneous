package features


import io.cucumber.java8.En
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert
import sk.kasper.base.utils.toTimeStamp
import java.time.LocalDate


class LocalDateTestSteps : En {

    private lateinit var today: LocalDate
    private lateinit var tomorrow: LocalDate

    private lateinit var actualAnswer: String
    init {
        Given("Today's date") {
            today = LocalDate.now();
        }
        When("I get tomorrow's date") {
            tomorrow = today.plusDays(1);
        }
        Then("It should be after today") {
            assertTrue(tomorrow.isAfter(today));
        }

    }
}