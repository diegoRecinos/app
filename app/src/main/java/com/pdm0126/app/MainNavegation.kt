package com.pdm0126.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

import com.pdm0126.app.ui.screens.homescreen.HomeScreen
import com.pdm0126.app.ui.screens.screen2.Screen2
import com.pdm0126.app.ui.screens.screen1.Screen1

@Composable
fun App(modifier: Modifier = Modifier){

    val backStack = rememberNavBackStack(Routes.HomeScreen)

    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) { innerPadding ->

        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),

            onBack = { backStack.removeLastOrNull()},

            entryProvider = entryProvider{

                entry<Routes.HomeScreen>{
                    HomeScreen(
                        onNavigateToScreen1 = { backStack.add(Routes.Screen1) },
                        onNavigateToScreen2 = { backStack.add(Routes.Screen2) }
                    )
                }

                entry<Routes.Screen1>{
                    Screen1(onBack = { backStack.removeLastOrNull() })
                }

                entry<Routes.Screen2>{
                    Screen2(onBack = {backStack.removeLastOrNull()})
                }

            }

        )
    }

}