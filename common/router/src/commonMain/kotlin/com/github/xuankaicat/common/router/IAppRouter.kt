package com.github.xuankaicat.common.router

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import com.github.xuankaicat.common.core.main.IMain

interface IAppRouter {
    val routerState: Value<RouterState<*, Child>>

    sealed class Child {
        data class Main(val component: IMain) : Child()
    }
}