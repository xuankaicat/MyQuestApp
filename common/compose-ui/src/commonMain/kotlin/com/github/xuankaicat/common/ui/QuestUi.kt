package com.github.xuankaicat.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.xuankaicat.common.utils.LaTeX

@Composable
fun QuestContent(
    modifier: Modifier = Modifier,
) {
    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(16.dp, 8.dp, 16.dp, 0.dp)
                .border(border = BorderStroke(4.dp, Color.Black))
        ) {
            Box(
                modifier = modifier.padding(4.dp)
                    .fillMaxSize()
            ) {
                val str = """
                    \frac{\partial f}{\partial x} = 2\,\sqrt{a}\,x
                """.trimIndent()

                LaTeX(str = str,
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .padding(start = 48.dp),
                )

            }
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(4f)
        ) {
            val btnModifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 8.dp)
                .heightIn(min = 48.dp, max = 64.dp)
                .height(96.dp)
                .weight(1f, false)

            for (i in 0 until 4) {
                AnswerButton(
                    modifier = btnModifier
                ) {
                    Text(i.toString())
                }
            }
        }
    }
}

@Composable
fun AnswerButton(
    modifier: Modifier = Modifier,
    onclick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onclick,
        content = content
    )
}