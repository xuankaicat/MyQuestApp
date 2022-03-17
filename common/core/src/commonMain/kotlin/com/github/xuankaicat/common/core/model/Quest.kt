package com.github.xuankaicat.common.core.model

data class Quest(
    val question: String,
    val answers: List<String>,
    val correctAnswerCount: Short = 1,
)

val testQuests
    get() = listOf(
        Quest(
            question = """
                1-cos\,x\sim\square
            """.trimIndent(),
            answers = listOf(
                """
                    \frac{1}{2}x^{2}
                """.trimIndent(),
                """
                    x
                """.trimIndent(),
                """
                    -\frac{1}{2}x^{2}
                """.trimIndent(),
                """
                    \frac{1}{6}x^{3}
                """.trimIndent(),
            )
        ),
    )