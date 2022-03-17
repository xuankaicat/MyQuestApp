package com.github.xuankaicat.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.xuankaicat.common.core.model.testQuests
import com.github.xuankaicat.common.utils.LaTeX

@Composable
fun QuestContent(
    modifier: Modifier = Modifier,
) {
    val quest = testQuests[0]
    var color by remember { mutableStateOf(Color.Black) }

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
                LaTeX(str = quest.question,
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .padding(start = 48.dp),
                    textColor = color,
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

            for (i in 0 until quest.answers.size) {
                AnswerButton(
                    modifier = btnModifier,
                    onclick = {
                        color = if(quest.correctAnswerCount - 1 == i) {
                            Color.Green
                        } else {
                            Color.Red
                        }
                    }
                ) {
                    LaTeX(
                        str = quest.answers[i],
                        textColor = Color.White
                    )
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