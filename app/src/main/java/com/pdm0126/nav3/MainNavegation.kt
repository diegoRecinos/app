package com.pdm0126.nav3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

@Composable
fun App(modifier: Modifier = Modifier){
    //creando el backstack
    val backStack = rememberNavBackStack()

    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) { innerPadding ->

        //navdisplay contenedor que renderiza las pantallas
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),
            //maneja boton de atras
            onBack = { backStack.removeLastOrNull()},

            entryProvider = entryProvider{
                //mapear cada objeto de routes.kt a un composable
//                entry<Routes.HomeScreen>{
//                    HomeScreen(
//                    )
//                }

                //entry<Routes.Screen2>{
//                   Screen2(onBack = {backStack.removeLastOrNull()})
//                }

//                entry<Routes.Screen3>{
//                    Screeen3(onBack = {backStack.removeLastOrNull()})
//                }

            }

        )
    }

}