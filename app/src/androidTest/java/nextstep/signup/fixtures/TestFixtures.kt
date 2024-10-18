package nextstep.signup.fixtures

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText

fun ComposeContentTestRule.nodeWithTextExists(text: String) {
    onNodeWithText(text).assertExists()
}

fun ComposeContentTestRule.nodeWithTextDoesNotExist(text: String) {
    onNodeWithText(text).assertDoesNotExist()
}
