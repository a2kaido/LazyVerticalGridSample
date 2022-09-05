package io.github.a2kaido.grid

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Test
import org.junit.runner.RunWith

private const val PACKAGE_NAME = "io.github.a2kaido.grid"

@RunWith(AndroidJUnit4::class)
class GridScrollTest {
    @Test
    fun scroll() {
        val device = UiDevice.getInstance(getInstrumentation())

        val launcherPackage: String = device.launcherPackageName
        device.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            1000,
        )

        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(PACKAGE_NAME).apply {
            this?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)

        // scroll LazyVerticalGrid
        device.swipe(100, 1500, 100, 500, 3)
        device.swipe(100, 1500, 100, 500, 3)
        Thread.sleep(5000)

        device.click(100, 1500)

        // scroll RecyclerView
        Thread.sleep(3000)
        device.swipe(100, 1500, 100, 500, 3)
        device.swipe(100, 1500, 100, 500, 3)

        Thread.sleep(3000)
    }
}