package com.hfad.trenatrena.Cardds

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hfad.trenatrena.CardList2
import com.hfad.trenatrena.Cards
import com.hfad.trenatrena.CheckboxM3
import com.hfad.trenatrena.Main
import com.hfad.trenatrena.MenusM3
import com.hfad.trenatrena.ProbaSli

sealed class Screen(val route: String) {
    object CardList : Screen("CardList")
    object ProbaSli : Screen("ProbaSli")
    object Main : Screen("Main")
    object AddCardScreen : Screen("AddCardScreen")
    object CardList2 : Screen("CardList2")
    object MenusM3 : Screen("MenusM3")
    object Cards : Screen("Cards")
    object CheckboxM3 : Screen("CheckboxM3")
}

@Composable
fun Navigate(
    cardList: MutableList<CardItem>, // Список карточек
    counter: MutableState<Int> // Счётчик для уникальных ID
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CardList.route,
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
        composable(Screen.CheckboxM3.route) {
            CheckboxM3(navController)
        }
        // Маршрут для экрана добавления карточки
        // Определяем композируемый экран с использованием маршрута экрана 'AddCardScreen'
        composable(Screen.AddCardScreen.route) {
            // Создаем экран добавления карточки, передавая необходимые параметры
            AddCardScreen(
                // Обработчик события сохранения карточки
                onSave = { title, description -> // Теперь функция принимает два параметра: заголовок и описание
                    // Увеличиваем счетчик карточек на 1 при каждом сохранении новой карточки
                    counter.value++

                    // Добавляем новую карточку в список карточек
                    cardList.add(
                        // Создаем новый объект CardItem с уникальным id, заголовком и описанием
                        CardItem(
                            id = counter.value, // Устанавливаем id как текущее значение счетчика
                            title = title, // Заголовок, который передан в параметрах
                            description = description // Описание, которое также передано в параметрах
                        )
                    )
                },
                // Передаем навигационный контроллер для управления переходами между экранами
                navController = navController
            )


        }
    }
}