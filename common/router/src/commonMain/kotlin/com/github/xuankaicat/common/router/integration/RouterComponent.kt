package com.github.xuankaicat.common.router.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.github.xuankaicat.common.core.main.IMain
import com.github.xuankaicat.common.core.main.integration.MainComponent
import com.github.xuankaicat.common.router.IAppRouter
import com.github.xuankaicat.common.router.IAppRouter.Child
import com.github.xuankaicat.common.utils.Consumer

class RouterComponent internal constructor(
    componentContext: ComponentContext,
    private val main: (ComponentContext, Consumer<IMain.Output>) -> IMain,
) : IAppRouter, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
    ) : this(
        componentContext = componentContext,
        main = { childContext, output ->
            MainComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
                output = output,
            )
        },
    )

    private val router =
        router<Configuration, Child>(
            initialConfiguration = Configuration.Main,
            handleBackButton = true,
            childFactory = ::createChild
        )

    override val routerState: Value<RouterState<*, Child>> = router.state

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child =
        when (configuration) {
            is Configuration.Main -> Child.Main(main(componentContext, Consumer(::onMainOutput)))
        }

    private fun onMainOutput(output: IMain.Output): Unit =
        when (output) {
            is IMain.Output.Finished -> router.pop()
        }

    private sealed class Configuration : Parcelable {
        @Parcelize
        object Main : Configuration()
    }
}