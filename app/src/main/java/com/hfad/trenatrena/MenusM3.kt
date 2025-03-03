package com.hfad.trenatrena

import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hfad.trenatrena.ui.theme.label
import com.hfad.trenatrena.ui.theme.textfield

@Composable
fun MenusM3(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    var text2 by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.wrapContentSize()
    ) {
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
            trailingIcon = {
                IconButton(
                    onClick = { expanded = true }
                ) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Edit"
                            )
                        },
                        onClick = {},
                        leadingIcon = {
                            Icon(Icons.Default.Edit, contentDescription = null)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Setting"
                            )
                        },
                        onClick = {},
                        leadingIcon = {
                            Icon(Icons.Default.Settings, contentDescription = null)
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = "Send"
                            )
                        },
                        onClick = {},
                        leadingIcon = {
                            Icon(Icons.Default.Send, contentDescription = null)
                        }
                    )
                }
            }
        )

    }
}

