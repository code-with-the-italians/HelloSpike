package it.codewiththeitalians.hellospike

import android.app.Application
import it.codewiththeitalians.hellospike.logging.CrashAndLog

class HelloSpikeApp : Application() {
    override fun onCreate() {
        super.onCreate()

       CrashAndLog.setupTimber()
    }
}