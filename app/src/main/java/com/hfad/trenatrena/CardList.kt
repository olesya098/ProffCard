package com.hfad.trenatrena

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
data class CardItem(
    val id: Int, // Уникальный идентификатор карточки
    val title: String, // Заголовок карточки
    val description: String // Описание карточки
)
@Composable
fun CardList(
    navController: NavController, // Контроллер навигации
    cardList: List<CardItem> // Список карточек
) {
    // Вертикальный контейнер, который занимает весь экран
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Кнопка для добавления новой карточки
        Button(
            onClick = {
                // Переходим на экран AddCardScreen
                navController.navigate(Screen.AddCardScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth() // Занимает всю ширину экрана
                .padding(16.dp) // Отступы
        ) {
            // Текст на кнопке
            Text(text = "Добавить карточку")
        }

        // Ленивый список для отображения карточек
        LazyColumn(
            modifier = Modifier.fillMaxSize() // Занимает весь оставшийся экран
        ) {
            // Отображаем каждую карточку в списке
            items(cardList) { card ->
                // Компонент для отображения одной карточки
                CardItemView(card = card)
            }
        }
    }
}
@Composable
fun CardItemView(card: CardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = card.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = card.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}