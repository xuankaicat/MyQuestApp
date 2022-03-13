package com.github.xuankaicat.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun MathMLToPainter(str: String): Painter