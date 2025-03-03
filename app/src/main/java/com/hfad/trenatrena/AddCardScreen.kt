package com.hfad.trenatrena

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@Composable
fun AddCardScreen(
    onSave: (String, String) -> Unit, // Функция для сохранения карточки
    navController: NavController // Контроллер навигации
) {
    var cardTitle by remember { mutableStateOf("") } // Состояние для названия
    var cardDescription by remember { mutableStateOf("") } // Состояние для описания

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Поле для ввода названия
        TextField(
            value = cardTitle,
            onValueChange = { cardTitle = it },
            label = { Text("Название карточки") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Поле для ввода описания
        TextField(
            value = cardDescription,
            onValueChange = { cardDescription = it },
            label = { Text("Описание карточки") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Кнопка для сохранения
        Button(
            onClick = {
                if (cardTitle.isNotBlank() && cardDescription.isNotBlank()) {
                    onSave(cardTitle, cardDescription)
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить")
        }
    }
}