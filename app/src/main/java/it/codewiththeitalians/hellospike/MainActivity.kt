package it.codewiththeitalians.hellospike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import it.codewiththeitalians.hellospike.ui.theme.HelloSpikeTheme
import timber.log.Timber

/**
 * INBOX
 *
 * 1. Add Timber ✅
 * 2. Add Crashlytics ✅
 * 3. Wire Timber+Crashlytics ✅
 * 4. Profit ✅
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloSpikeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Hello Spike!",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(32.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.spike),
                            contentDescription = "A picture of Spike",
                            modifier = Modifier.padding(32.dp)
                        )
                    }
                }
            }
        }
        catchMe()
    }

    private fun catchMe() {
        try {
            error("Catch me")
        } catch (e: Exception) {
            // handle crash
            Timber.e(e)
        }
    }
}