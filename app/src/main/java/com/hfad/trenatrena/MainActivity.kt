package com.hfad.trenatrena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hfad.trenatrena.Cardds.CardItem
import com.hfad.trenatrena.Cardds.Navigate
import com.hfad.trenatrena.ui.theme.TrenaTrenaTheme
import com.hfad.trenatrena.ui.theme.blue
import com.hfad.trenatrena.ui.theme.gray
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrenaTrenaTheme {
                // Создаём список карточек, который будет автоматически обновлять UI при изменении
                val cardList = remember {
                    mutableStateListOf(
                        CardItem(1, "Карточка 1", "Описание карточки 1"),
                        CardItem(2, "Карточка 2", "Описание карточки 2"),
                        CardItem(3, "Карточка 3", "Описание карточки 3")
                    )
                }
                // Создаём счётчик для генерации уникальных ID карточек
                val counter = remember { mutableStateOf(0) }

                // Контейнер, который занимает весь экран и использует цвет фона из темы
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Запускаем навигацию, передавая список карточек и счётчик
                    Navigate(cardList = cardList, counter = counter)
                }
            }
        }
    }
}
@Composable
fun Main(navController: NavController) {
    Scaffold(
        bottomBar = { Greeting() }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        )

    }
}
@Composable
fun Greeting() {
    var select by remember { mutableStateOf(0) }

    androidx.compose.material3.NavigationBar(
        modifier = Modifier.height(140.dp),
        containerColor = gray
    ) {
        NavigationBarItem(
            selected = select == 0,
            onClick = { select = 0 },
            label = {
                Text(
                    text = "Home",
                    color = Color.White
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = null,
                    tint = if (select == 0) blue else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.White,
                indicatorColor = Color.Transparent,
                selectedIconColor = blue,
                unselectedTextColor = Color.Transparent,
                unselectedIconColor = blue
            ),
            alwaysShowLabel = false // Подпись отображается только при выборе
        )

        NavigationBarItem(
            selected = select == 1,
            onClick = { select = 1 },
            label = {
                Text(
                    text = "Favorit",
                    color = Color.White
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = null,
                    tint =  if (select == 1) blue else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.White,
                indicatorColor = Color.Transparent,
                selectedIconColor = blue,
                unselectedTextColor = Color.Transparent,
                unselectedIconColor = blue
            ),
            alwaysShowLabel = false // Подпись отображается только при выборе
        )

        NavigationBarItem(
            selected = select == 2,
            onClick = { select = 2 },
            label = {
                Text(
                    text = "Profil",
                    color = Color.White
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null,
                    tint =  if (select == 2) blue else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.White,
                indicatorColor = Color.Transparent,
                selectedIconColor = blue,
                unselectedTextColor = Color.Transparent,
                unselectedIconColor = blue
            ),
            alwaysShowLabel = false // Подпись отображается только при выборе
        )

        NavigationBarItem(
            selected = select == 3,
            onClick = { select = 3 },
            label = {
                Text(
                    text = "Setting",
                    color = Color.White
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = null,
                    tint =  if (select == 3) blue else Color.White
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color.White,
                indicatorColor = Color.Transparent,
                selectedIconColor = blue,
                unselectedTextColor = Color.Transparent,
                unselectedIconColor = blue
            ),
            alwaysShowLabel = false // Подпись отображается только при выборе
        )
    }
}

data class Slide(
    val image: Int,
    val text1: String,
    val text2: String,
    val text3: String,
    val textButton: String,
) {}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProbaSli(navController: NavController) {
    val slider = listOf(
        Slide(
            image = R.drawable.cross1,
            "Привет",
            "Как",
            "Дела",
            "Далее"

        ),
        Slide(
            image = R.drawable.cross1,
            "Привет",
            "Как",
            "Дела",
            "Далее"

        ),
        Slide(
            image = R.drawable.cross1,
            "Привет",
            "Как",
            "Дела",
            "Далее"

        )

    )
    val gradient = Brush.linearGradient(
        colors = listOf(
            Color(72, 178, 231, 255),
            Color(47, 141, 189, 255),
            Color(22, 105, 147, 255),
            Color(8, 75, 108, 255),
        )
    )
    val pagerState = rememberPagerState(pageCount = { slider.size })
    val coroutine = rememberCoroutineScope()

    Surface(modifier = Modifier.fillMaxSize()) {
        val visible = remember {
            List(slider.size) { mutableStateOf(false) }

        }


        LaunchedEffect(pagerState.currentPage) {
            visible.forEach { it.value = false }
            delay(100)
            visible[pagerState.currentPage].value = true
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(top = 70.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                userScrollEnabled = false
            ) {page ->
                val sli = slider[page]

                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    AnimatedVisibility(
                        visible = visible[page].value,
                        enter = fadeIn(tween(700)),
                        exit = fadeOut(tween(700))
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = sli.text1
                            )
                            Text(
                                text = sli.text2
                            )
                            Text(
                                text = sli.text3
                            )
                            Image(
                                painter = painterResource(id = sli.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp)
                            )



                        }

                    }
                }

            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ){
                repeat(slider.size){ index ->
                    val color = if (pagerState.currentPage == index) Color.White else Color.White.copy(alpha = 0.3f)
                    val w = if (pagerState.currentPage == index) 49.dp else 29.dp
                    Box(
                        modifier = Modifier
                            .padding(6.dp)
                            .background(color,
                                CircleShape)
                            .size(width = w, height = 6.dp)
                    )
                }
            }
            Button(onClick = {
                if (pagerState.currentPage < slider.size - 1){
                    coroutine.launch {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                }else{

                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = blue
                ),
                modifier = Modifier.padding(bottom = 62.dp)
                    .fillMaxWidth()
                    .height(50.dp)
        ) {
                Text(
                    slider[pagerState.currentPage].textButton,
                    color = Color.White
                )
            }

        }

    }

}

@Composable
fun ThemeExample() {
    // Определяем, использует ли система тёмную тему
    val isDarkTheme = isSystemInDarkTheme()

    // Выбираем цветовую схему в зависимости от темы
    val colors = if (isDarkTheme) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
            secondary = Color(0xFF03DAC6),
            background = Color(0xFF121212),
            surface = Color(0xFF1E1E1E),
            onPrimary = Color.Black,
            onSecondary = Color.Black,
            onBackground = Color.White,
            onSurface = Color.White
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF6200EE),
            secondary = Color(0xFF03DAC6),
            background = Color.White,
            surface = Color.White,
            onPrimary = Color.White,
            onSecondary = Color.Black,
            onBackground = Color.Black,
            onSurface = Color.Black
        )
    }

    // Применяем выбранную цветовую схему
    MaterialTheme(colorScheme = colors) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isDarkTheme) "Тёмная тема" else "Светлая тема",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewThemeExample() {

    ThemeExample()

}