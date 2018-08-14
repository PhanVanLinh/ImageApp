package vn.linh.imageapp.utils.common

import java.util.concurrent.TimeUnit

class Duration private constructor(private val durationMillis: Long) {

    fun duration(): Long {
        return durationMillis
    }

    override fun equals(obj: Any?): Boolean {
        return obj is Duration && obj.durationMillis == durationMillis
    }

    companion object {

        fun from(durationMillis: Long): Duration {
            return Duration(durationMillis)
        }

        fun from(duration: Long, unit: TimeUnit): Duration {
            return Duration(unit.toMillis(duration))
        }
    }
}
