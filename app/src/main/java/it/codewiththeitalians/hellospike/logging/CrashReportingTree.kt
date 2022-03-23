package it.codewiththeitalians.hellospike.logging

import android.util.Log.ERROR
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class CrashReportingTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        val crashlytics = FirebaseCrashlytics.getInstance()
        crashlytics.log(message)

        if (priority == ERROR) {
            if (t == null) crashlytics.recordException(Throwable(message))
            else crashlytics.recordException(t)
        }
    }
}