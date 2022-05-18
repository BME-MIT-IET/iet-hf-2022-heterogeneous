package features

import org.junit.Before
import org.mockito.Mock
import org.threeten.bp.LocalDateTime
import sk.kasper.base.notification.EnqueueLaunchNotification
import sk.kasper.domain.usecase.impl.ScheduleLaunchNotificationsImpl

class ScheduleLaunchNotificationsImplTestSource {
    private  lateinit var source:ScheduleLaunchNotificationsImplTestSource

    init {
        setUp()
    }

    fun  getMyInstance():ScheduleLaunchNotificationsImplTestSource{
        source= ScheduleLaunchNotificationsImplTestSource()
        return source
    }
    internal fun getScheduleLaunchNotifications():ScheduleLaunchNotificationsImpl{
        return scheduleLaunchNotifications
    }

    internal fun getEnqueueLaunchNotification():EnqueueLaunchNotification{
        return enqueueLaunchNotification
    }

    companion object {
        private val CURRENT_DATE_TIME: LocalDateTime = LocalDateTime.of(2001, 4, 30, 10, 0)
        private const val LAUNCH_ID = "id"
    }

    private lateinit var scheduleLaunchNotifications: ScheduleLaunchNotificationsImpl

    @Mock
    private lateinit var enqueueLaunchNotification: EnqueueLaunchNotification

    @Before
    fun setUp() {
        scheduleLaunchNotifications = ScheduleLaunchNotificationsImpl(
            enqueueLaunchNotification
        ) { CURRENT_DATE_TIME }
    }
}