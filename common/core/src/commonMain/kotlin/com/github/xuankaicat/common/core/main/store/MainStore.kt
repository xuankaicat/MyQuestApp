package com.github.xuankaicat.common.core.main.store

import com.arkivanov.mvikotlin.core.store.Store
import com.github.xuankaicat.common.core.main.store.MainStore.*

internal interface MainStore : Store<Intent, State, Label> {

    sealed class Intent {
        data class AddData(val num: Int): Intent()
    }

    data class State(
        val data: Int = 0
    )

    sealed interface Label {
    }
}