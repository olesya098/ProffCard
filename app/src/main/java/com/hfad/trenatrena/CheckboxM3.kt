package com.hfad.trenatrena

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun CheckboxM3(navController: NavController) {
    val items = listOf("да", "немного", "чучуть", "полностью")
    val checkboxStates = remember { mutableStateMapOf<String, Boolean>().withDefault { false } }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        items.forEach { item ->
            // Создаем строку (Row) для отображения элементов по горизонтали
            Row(
                modifier = Modifier // Устанавливаем модификаторы для настройки внешнего вида Row
                    .fillMaxWidth() // Строка будет занимать всю ширину доступного пространства
                    .height(56.dp) // Высота строки фиксируется на уровне 56 dp (density-independent pixels)
                    .toggleable( // Добавляем интерактивный модификатор, который делает Row переключаемым
                        value = checkboxStates.getValue(item), // Получаем текущее состояние (true или false) для элемента по ключу 'item' из коллекции 'checkboxStates'
                        onValueChange = { // Обработка изменения состояния при взаимодействии с пользователем
                            checkboxStates[item] = it // Обновляем состояние элемента в 'checkboxStates' при изменении (it содержит новое значение)
                        }
                    )
                    .padding(horizontal = 16.dp), // Добавляем горизонтальные отступы по 16 dp слева и справа
                verticalAlignment = Alignment.CenterVertically // Выравниваем содержимое внутри строки по вертикали по центру
            ) {

            Checkbox(
                    checked = checkboxStates.getValue(item),
                    onCheckedChange = null
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}