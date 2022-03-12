package ui

import androidx.compose.runtime.*
import com.github.xuankaicat.common.core.main.IMain
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexFlow
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLUListElement
import subscribeAsState


@Composable
fun MainUi(component: IMain) {
    val model by component.models.subscribeAsState()

    var addValue by remember { mutableStateOf("1") }

    Div {
        Text(model.data.toString())
        Div {

            TextInput(addValue) {
                onInput { addValue = it.value }
            }

            Button(
                attrs = {
                    onClick {
                        component.onDataButtonClicked(addValue.toInt())
                    }
                    style {
                        width(100.px)
                    }
                }
            ) {
                Text("加")
            }
        }

    }
}