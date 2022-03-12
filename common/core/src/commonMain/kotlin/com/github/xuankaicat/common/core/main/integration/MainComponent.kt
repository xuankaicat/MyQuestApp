package com.github.xuankaicat.common.core.main.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.github.xuankaicat.common.core.main.IMain
import com.github.xuankaicat.common.core.main.IMain.Model
import com.github.xuankaicat.common.core.main.IMain.Output
import com.github.xuankaicat.common.core.main.store.MainStore.Intent
import com.github.xuankaicat.common.core.main.store.MainStoreFactory
import com.github.xuankaicat.common.utils.asValue

class MainComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val output: Consumer<Output>
) : IMain, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        MainStoreFactory(
            storeFactory = storeFactory,
        ).create()
    }

    override val models: Value<Model> = store.asValue().map(stateToModel)

    override fun onDataButtonClicked(num: Int) {
        store.accept(Intent.AddData(num))
    }
}