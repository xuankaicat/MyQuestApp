package com.github.xuankaicat.common.core.main

import com.arkivanov.decompose.value.Value

interface IMain {

    val models: Value<Model>

    fun onDataButtonClicked(num: Int)

    data class Model(
        val data: Int,
    )

    sealed class Output {
        object Finished : Output()
    }
}