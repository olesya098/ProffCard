package com.hfad.trenatrena

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.trenatrena.ui.theme.blue
import com.hfad.trenatrena.ui.theme.label
import com.hfad.trenatrena.ui.theme.textfield


@Composable
fun LogIn() {
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .background(
                        MaterialTheme.colorScheme.background,
                        shape = CircleShape
                    )
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )

            }
            // Привет!
            Text(
                text = "Привет!",
                fontSize = 32.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )

            Text(
                text = "Заполните Свои данные или \n продолжите через социальные медиа",
                textAlign = TextAlign.Center,
                color = Color(0x77707B81)

            )
            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Email",
                textAlign = TextAlign.Start
            )

            fun isEmail(email: String): Boolean {
                val pattern = """^[a-z0-9]+@gmail\.com${'$'}""".toRegex()
                return pattern.matches(email)
            }
            fun isPasswordValid(password: String): Boolean {
                val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$".toRegex()
                return passwordPattern.matches(password)
            }
            TextField(
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = textfield,
                    disabledContainerColor = Color(0xFFE0E0E0),
                    unfocusedContainerColor = textfield,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.primary,
                    focusedTextColor = MaterialTheme.colorScheme.background,
                    unfocusedTextColor = MaterialTheme.colorScheme.background
                ),
                label = {
                    Text(
                        text = "xyz@gmail.com"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

            )



            Text(
                text = "Пароль",
                modifier = Modifier.padding(top = 22.dp),
                textAlign = TextAlign.Start
            )
            TextField(
                value = text2,
                onValueChange = {
                    text2 = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = textfield,
                    disabledContainerColor = Color(0xFFE0E0E0),
                    unfocusedContainerColor = textfield,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = label,
                    unfocusedLabelColor = label,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                label = {
                    Text(
                        text = "••••••••"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = painterResource(id = R.drawable.cross1) ,
                            contentDescription = if (passwordVisible) "Скрыть пароль" else "Показать пароль",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
            Text(
                text = "Восстановить",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 22.dp)
                    .clickable {
                        },
                color = label,
                fontSize = 14.sp
            )
            Button(
                onClick = {
                    if (!isEmail(email)) {
                        errorMessage = "Некорректный формат Email"
                        showError = true
                    } else if (!isPasswordValid(text2)) {
                        errorMessage = "Пароль должен содержать минимум 8 символов, одну цифру, одну заглавную букву и один специальный символ."
                        showError = true
                    } else {

                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(top = 12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = blue)
            ) {
                Text(
                    text = "Войти",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            if (showError) {
                AlertDialog(
                    onDismissRequest = { showError = false },
                    title = { Text("Ошибка") },
                    text = { Text(errorMessage) },
                    confirmButton = {
                        TextButton(onClick = { showError = false }) {
                            Text("OK")
                        }
                    }
                )
            }


            Spacer(modifier = Modifier.height(140.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight() // Добавляем это для заполнения всей высоты
                    .padding(bottom = 56.dp) // Отступ снизу вместо top
                    .wrapContentHeight(Alignment.Bottom), // Привязываем к нижней части
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Вы впервые? ",
                    color = label
                )
                Text(
                    text = "Создать пользователя",
                    color = Color.Black,
                    modifier = Modifier.clickable{

                    }
                )
            }
        }


    }
}