package com.github.xuankaicat.common.utils

import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
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
    return BitmapPainter(BitmapFactory.decodeStream(inputStream).asImageBitmap())
}