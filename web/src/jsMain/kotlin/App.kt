import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.github.xuankaicat.common.router.integration.RouterComponent
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.compose.web.ui.Styles
import org.w3c.dom.HTMLElement
import ui.RouterUi

fun main() {
    val rootElement = document.getElementById("root") as HTMLElement

    val lifecycle = LifecycleRegistry()

    val router =
        RouterComponent(
            componentContext = DefaultComponentContext(lifecycle = lifecycle),
            storeFactory = DefaultStoreFactory(),
        )

    lifecycle.resume()

    renderComposable(root = rootElement) {
        Style(Styles)

        RouterUi(router)
    }
}
