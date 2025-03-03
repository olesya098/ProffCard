package com.hfad.trenatrena

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Card(
    val image: Int,
    val text: String
) {}

@Composable
fun Cards(navController: NavController) {
    val cardd = listOf(
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),
        Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),Card(
            R.drawable.cross1,
            "Кроссовки M21"
        ),


    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(
            cardd
        ) { ca ->
            Ccard(c = ca)


        }
    }

}

@Composable
fun Ccard(c: Card){

    Card(
        modifier = Modifier.padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = c.image),
            contentDescription = null
        )
        Text(
            text = c.text
        )
    }

}