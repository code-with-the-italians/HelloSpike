package it.codewiththeitalians.hellospike.logging

import it.codewiththeitalians.hellospike.BuildConfig
import timber.log.Timber

object CrashAndLog {
    fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return "(${element.fileName}:${element.lineNumber})#${element.methodName}"
                }
            })
        } else {
            Timber.plant(CrashReportingTree())
        }
    }
}