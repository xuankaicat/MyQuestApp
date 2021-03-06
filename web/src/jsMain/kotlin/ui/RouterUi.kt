package ui

import Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.github.xuankaicat.common.router.IAppRouter
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width
import subscribeAsState

@Composable
fun RouterUi(component: IAppRouter) {
    Card(
        attrs = {
            style {
                position(Position.Absolute)
                height(700.px)
                property("max-width", 640.px)
                top(0.px)
                bottom(0.px)
                left(0.px)
                right(0.px)
                property("margin", auto)
            }
        }
    ) {
        val routerState by component.routerState.subscribeAsState()

        Crossfade(
            target = routerState.activeChild.instance,
            attrs = {
                style {
                    width(100.percent)
                    height(100.percent)
                    position(Position.Relative)
                    left(0.px)
                    top(0.px)
                }
            }
        ) { child ->
            when (child) {
                is IAppRouter.Child.Main -> MainUi(child.component)
            }
        }
    }
}
