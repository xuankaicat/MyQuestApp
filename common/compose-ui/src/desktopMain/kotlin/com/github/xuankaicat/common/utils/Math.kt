package com.github.xuankaicat.common.utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import org.scilab.forge.jlatexmath.TeXConstants
import org.scilab.forge.jlatexmath.TeXFormula
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

@Composable
actual fun LaTeX(
    str: String,
    modifier: Modifier,
    textColor: androidx.compose.ui.graphics.Color,
    fontSize: Float,
) {
    val style = TeXConstants.STYLE_DISPLAY
    val image = TeXFormula.createBufferedImage(
        str, style, fontSize / 2.5f, Color(textColor.hashCode()), null) as BufferedImage
    val stream = ByteArrayOutputStream()
    ImageIO.write(image, "png", stream)
    val inputStream = ByteArrayInputStream(stream.toByteArray())
    val painter = BitmapPainter(loadImageBitmap(inputStream))

    Image(modifier = modifier,
        painter = painter,
        contentDescription = str,
        contentScale = ContentScale.FillHeight
    )
}