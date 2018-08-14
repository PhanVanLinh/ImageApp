package vn.linh.imageapp.utils.common

import java.util.ArrayList
import java.util.Timer
import java.util.TimerTask

import javax.inject.Inject

class IntervalScheduler @Inject
constructor() {
    private var delay: Long = 0
    private var period: Long = 0
    private var timer: Timer? = null
    private val schedulerListeners = ArrayList<SchedulerListener>()
    private var isCancelled: Boolean = false

    interface SchedulerListener {
        fun onSchedule()
    }

    fun delay(duration: Duration): IntervalScheduler {
        this.delay = duration.duration()
        return this
    }

    fun period(duration: Duration): IntervalScheduler {
        this.period = duration.duration()
        return this
    }

    fun period(): Duration {
        return Duration.from(period)
    }

    fun schedule() {
        cancel()
        timer = Timer()
        isCancelled = false
        if (period > 0) {
            timer!!.schedule(task(), delay, period)
        } else {
            timer!!.schedule(task(), delay)
        }
    }

    fun cancel() {
        if (timer == null || isCancelled) return
        timer!!.cancel()
        timer = null
        isCancelled = true
    }

    fun observe(listener: SchedulerListener) {
        if (!schedulerListeners.contains(listener)) {
            schedulerListeners.add(listener)
        }
    }

    fun unObserve(listener: SchedulerListener) {
        schedulerListeners.remove(listener)
        if (schedulerListeners.isEmpty() && timer != null) {
            cancel()
        }
    }

    private fun onSchedule() {
        for (listener in schedulerListeners) {
            listener.onSchedule()
        }
    }

    private fun task(): TimerTask {
        return object : TimerTask() {
            override fun run() {
                onSchedule()
            }
        }
    }
}
