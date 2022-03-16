package com.github.xuankaicat.common.utils

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.agog.mathdisplay.MTFontManager
import com.agog.mathdisplay.parse.MTLineStyle
import com.agog.mathdisplay.parse.MTMathList
import com.agog.mathdisplay.parse.MTMathListBuilder
import com.agog.mathdisplay.render.MTTypesetter

@Composable
actual fun LaTeX(
    str: String,
    modifier: Modifier,
    textColor: Color,
    fontSize: Float,
) {
    MTFontManager.setContext(LocalContext.current)

    val list: MTMathList = MTMathListBuilder.buildFromString(str) ?: return
    val font = MTFontManager.defaultFont()?.copyFontWithSize(fontSize)
    val currentStyle = MTLineStyle.KMTLineStyleDisplay
    val dl = MTTypesetter.createLineForMathList(list, font!!, currentStyle)

    dl.textColor = textColor.hashCode()

    val view = LocalView.current

    val textX = (view.width - view.paddingStart - view.paddingEnd + dl.width.toInt()) / 2 + view.paddingStart

    val availableHeight = view.height - view.paddingBottom - view.paddingTop

    var eqheight = dl.ascent + dl.descent
    if (eqheight < fontSize / 2) {
        // Set the height to the half the size of the font
        eqheight = fontSize / 2
    }

    val textY = (availableHeight - eqheight) / 2 + dl.descent + view.paddingBottom
    dl.position.x = textX.toFloat()
    dl.position.y = textY

    Canvas(modifier = modifier) {
        this.drawIntoCanvas {
            it.scale(1.0f, -1.0f)
            dl.draw(it.nativeCanvas)
        }
    }
}