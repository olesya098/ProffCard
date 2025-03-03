package com.hfad.trenatrena

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String){
    object CardList: Screen("CardList")
    object ProbaSli: Screen("ProbaSli")
    object Main: Screen("Main")
    object AddCardScreen: Screen("AddCardScreen")
    object CardList2: Screen("CardList2")
    object MenusM3: Screen("MenusM3")
    object Cards: Screen("Cards")
}
@Composable
fun Navigate(
    cardList: MutableList<CardItem>, // Список карточек
    counter: MutableState<Int> // Счётчик для уникальных ID
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Cards.route,
        modifier = Modifier.background(Color.Transparent)
    ) {
        composable(Screen.CardList.route) {
            // Передаём cardList в CardList
            CardList(navController = navController, cardList = cardList)
        }
        composable(Screen.CardList2.route) {
            // Передаём cardList в CardList
            CardList2(navController)
        }
        composable(Screen.ProbaSli.route) {
            ProbaSli(navController)
        }
        composable(Screen.Main.route) {
            Main(navController)
        }
        composable(Screen.MenusM3.route) {
            MenusM3(navController)
        }
        composable(Screen.Cards.route) {
            Cards(navController)
        }
        // Маршрут для экрана добавления карточки
        composable(Screen.AddCardScreen.route) {
            AddCardScreen(
                onSave = { title, description -> // Теперь функция принимает два параметра
                    counter.value++
                    cardList.add(
                        CardItem(
                            id = counter.value,
                            title = title,
                            description = description // Используем введённое описание
                        )
                    )
                },
                navController = navController
            )
        }
    }
}