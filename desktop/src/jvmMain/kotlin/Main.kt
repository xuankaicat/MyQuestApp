import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.github.xuankaicat.common.ui.QuestContent

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MaterialTheme {
            QuestContent()
        }
    }
}