package features

import io.cucumber.java8.En
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.eq
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.threeten.bp.LocalDateTime
import sk.kasper.domain.usecase.impl.ScheduleLaunchNotificationsImplTest
import sk.kasper.domain.utils.createLaunch

import javax.annotation.meta.When
class ScheduleLaunchNotificationsImplTestSteps : En {

    public var Schedule=ScheduleLaunchNotificationsImplTestSource().getMyInstance()
    private fun createLaunchAtTime(
        launchDateTime: LocalDateTime,
        accurateDate: Boolean = true,
        accurateTime: Boolean = true
    ) = createLaunch(
        id = ScheduleLaunchNotificationsImplTest.getLaunchId(),
        launchDateTime = ScheduleLaunchNotificationsImplTest.getCurrDateTime().plusDays(20),
        accurateDate = accurateDate,
        accurateTime = accurateTime
    )

    init {
        Given("launch date") {
            var launch = createLaunchAtTime(ScheduleLaunchNotificationsImplTest.getCurrDateTime().plusHours(22))
        }
        When("launch is in 22 hours") {
            var ScheduleLaunchNotificationsImpl=Schedule.getScheduleLaunchNotifications()
        }
        Then("the launch is enqueued") {
            var EnqueueLaunchNotification=Schedule.getEnqueueLaunchNotification()
            Mockito.verify(EnqueueLaunchNotification)
                .invoke(eq(ScheduleLaunchNotificationsImplTest.getLaunchId()), any())
        }
    }
}