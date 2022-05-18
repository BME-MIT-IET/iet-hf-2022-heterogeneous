package features


import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import io.cucumber.java8.En
import org.mockito.Mockito
import org.threeten.bp.LocalDateTime
import sk.kasper.domain.usecase.impl.ScheduleLaunchNotificationsImplTest
import sk.kasper.domain.utils.createLaunch

class ScheduleLaunchNotificationsImplTestSteps : En {

    public var Schedule=ScheduleLaunchNotificationsImplTestSource().getInstance()
    private fun createLaunchAtTime(
        launchDateTime: LocalDateTime,
        accurateDate: Boolean = true,
        accurateTime: Boolean = true
    ) = createLaunch(
        id = ScheduleLaunchNotificationsImplTest.LAUNCH_ID,
        launchDateTime = launchDateTime,
        accurateDate = accurateDate,
        accurateTime = accurateTime
    )

    init {
        Given("launch date") {
            var launch = createLaunchAtTime(ScheduleLaunchNotificationsImplTest.CURRENT_DATE_TIME.plusHours(22))
        }
        When("luanch is in 22 hours") {
            var ScheduleLaunchNotificationsImpl=Schedule.getScheduleLaunchNotifications()
        }
        Then("the launch is enqueued") {
            var EnqueueLaunchNotification=Schedule.getEnqueueLaunchNotification()
            Mockito.verify(EnqueueLaunchNotification)
                .invoke(eq(ScheduleLaunchNotificationsImplTest.LAUNCH_ID), any())
        }
    }
}