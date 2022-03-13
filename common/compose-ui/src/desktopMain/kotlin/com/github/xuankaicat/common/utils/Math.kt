package com.github.xuankaicat.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.loadImageBitmap
import net.sourceforge.jeuclid.context.LayoutContextImpl
import net.sourceforge.jeuclid.context.Parameter
import net.sourceforge.jeuclid.converter.Converter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

val layoutContext by lazy {
    (LayoutContextImpl.getDefaultLayoutContext() as LayoutContextImpl).apply {
        setParameter(Parameter.MATHSIZE, 30)
    }
}

@Composable
actual fun MathMLToPainter(str: String): Painter {
    val converter = Converter.getInstance()
    val stream = ByteArrayOutputStream()
    converter.convert(str, stream, "image/png", layoutContext)
    val inputStream = ByteArrayInputStream(stream.toByteArray())
    return BitmapPainter(loadImageBitmap(inputStream))
}