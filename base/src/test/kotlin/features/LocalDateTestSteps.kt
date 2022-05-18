package features



import io.cucumber.java8.En
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.threeten.bp.format.TextStyle
import sk.kasper.base.utils.toTimeStamp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters
import java.util.*


class LocalDateTestSteps : En {

    private lateinit var today: LocalDate
    private lateinit var tomorrow: LocalDate
    private lateinit var date: LocalDate
    private lateinit var nextdate: LocalDate
    private lateinit var night: LocalDateTime
    private lateinit var midnight: LocalDateTime
    private lateinit var todayDay: DayOfWeek



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

        Given("Date is {int} {string} {int}") { year : Int, month: String, day : Int ->
            date= LocalDate.of(year, Month.valueOf(month), day)
            nextdate=date.with(TemporalAdjusters.next(DayOfWeek.MONDAY))
        }
        Then("It is {string}") { honap: String ->
            assertTrue(date.dayOfWeek==DayOfWeek.valueOf(honap));
        }
        And("Next monday is on {int} th") { day : Int ->
            assertTrue(nextdate.dayOfMonth == day)
        }

        Given("Date is {int} {string} {int} time: {int} {int}") { year : Int, month: String, day : Int, hour : Int, min : Int ->
            night= LocalDateTime.of(year, Month.valueOf(month), day, hour, min);
            midnight=night
                .plusDays(1)
                .withHour(0)
                .withSecond(0)
        }

        Then("It is before midnight") {
            assertTrue(night.isBefore(midnight))
        }

        Then("It should display {string}") {day: String ->
            assertEquals(todayDay.getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH), day)

        }
        And("{string}") {day: String ->
            assertEquals(todayDay.getDisplayName(java.time.format.TextStyle.NARROW, Locale.ENGLISH), day)
        }
        Given("The day is {string}") {day: String ->
            todayDay=DayOfWeek.valueOf(day)
        }

        Given("Date time of \"America/Los_Angeles\" and \"Asia/Tokyo\"") {
            TODO("Not yet implemented")
        }
        When("we get the timezones") {
            TODO("Not yet implemented")
        }
        Then("Tokyo time is plus 10 hours and 50 minutes") {
            TODO("Not yet implemented")
        }
    }
}