package com.github.xuankaicat.common.core.main.integration

import com.github.xuankaicat.common.core.main.IMain.Model
import com.github.xuankaicat.common.core.main.store.MainStore.State

internal val stateToModel: (State) -> Model =
    {
        Model(
            data = it.data
        )
    }