package com.github.xuankaicat.common.core.main.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.github.xuankaicat.common.core.main.store.MainStore.*

internal class MainStoreFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): MainStore =
        object : MainStore, Store<Intent, State, Label> by storeFactory.create(
            name = "MainStore",
            initialState = State(),
            bootstrapper = BootstrapperImpl(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private sealed class Msg {
        class Value(val value: Int) : Msg()
    }

    private sealed class Action {
        class SetValue(val value: Int): Action()
    }

    private class BootstrapperImpl : CoroutineBootstrapper<Action>() {
        override fun invoke() {

        }
    }

    private class ExecutorImpl : CoroutineExecutor<Intent, Action, State, Msg, Nothing>() {
        override fun executeIntent(intent: Intent, getState: () -> State) {
            when(intent) {
                is Intent.AddData -> dispatch(Msg.Value(getState().data + intent.num))
            }
        }

        override fun executeAction(action: Action, getState: () -> State) {
            when(action) {
                is Action.SetValue -> dispatch(Msg.Value(action.value))
            }
        }
    }

    private object ReducerImpl : Reducer<State, Msg> {
        override fun State.reduce(msg: Msg): State =
            when (msg) {
                is Msg.Value -> copy(data = msg.value)
            }
    }
}