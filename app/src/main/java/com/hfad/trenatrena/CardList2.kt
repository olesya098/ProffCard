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
import com.hfad.trenatrena.Cardds.CardItem

@Composable
fun CardList2 (navController: NavController) {
    // Состояние для хранения списка карточек
    val cardList = remember { mutableStateListOf<CardItem>() }
    // Счётчик для уникальных ID
    var counter by remember { mutableStateOf(0) }

    Column(
    modifier = Modifier.fillMaxSize()
    ) {
        // Кнопка для добавления новой карточки
        Button(
            onClick = {
                // Увеличиваем счётчик
                counter++
                // Добавляем новую карточку в список
                cardList.add(
                    CardItem(
                        id = counter,
                        title = "Карточка $counter",
                        description = "Описание карточки $counter"
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Добавить карточку")
        }

        // Список карточек
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(cardList) { card ->
                CardItemView2(card = card)
            }
        }
    }
}
@Composable
fun CardItemView2(card: CardItem) {
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