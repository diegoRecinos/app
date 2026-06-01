package com.pdm0126.app

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable



@Serializable
//navkey is the key to identify the destination
sealed interface Routes : NavKey {

    @Serializable
    data object HomeScreen: Routes{

    }

    @Serializable
    data object Screen1: Routes{

    }

    @Serializable
    data object Screen2: Routes{

    }


}