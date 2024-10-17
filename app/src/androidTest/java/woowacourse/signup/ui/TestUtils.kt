package woowacourse.signup.ui

import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry

fun testStringResource(
    @StringRes id: Int,
): String {
    val context = InstrumentationRegistry.getInstrumentation().targetContext
    return context.resources.getString(id)
}
