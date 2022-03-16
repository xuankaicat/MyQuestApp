package com.github.xuankaicat.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
expect fun LaTeX(
    str: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    fontSize: Float = 80f,
)