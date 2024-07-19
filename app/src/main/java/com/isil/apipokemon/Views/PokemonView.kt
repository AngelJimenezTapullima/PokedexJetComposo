package com.isil.apipokemon.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.isil.apipokemon.Models.Pokemones
import com.isil.apipokemon.ViewModel.PokemonViewModel

@Composable
fun PokemonView(NavController: NavHostController, viewModel: PokemonViewModel) {
    Scaffold(
        topBar = { TopBar(NavController) },
        content = {
            innerpadding ->
            Surface(modifier = Modifier.padding(innerpadding)){
                Contenido(NavController = NavController, viewModel = viewModel)
            }
        },
        containerColor = Color(0xFF243484)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(NavController: NavHostController){
    CenterAlignedTopAppBar(
        colors = topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White
        ),
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally){
                TextoSemiBold(texto = "POKEMON")
                Text(text = "by Angel Jimenez", fontSize = 14.sp)
            }
        }
    )
}

@Composable
fun Contenido(NavController: NavHostController, viewModel: PokemonViewModel) {
    if (viewModel.state.isLoading){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            CircularProgressIndicator()
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    listOf(
                        Color(0xFF2be4dc),
                        Color(0xFF6677CC),
                        Color(0xFF243484)
                    )
                )
            )
    ) {
        itemsIndexed(items = viewModel.response.drop(1)){
                index, item ->
            if (item != null) {
                PokemonCard(item = item, NavController = NavController)
            }
        }
    }
}

@Composable
fun PokemonCard(
    item: Pokemones,
    NavController: NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        Card(
//            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(150.dp)
                .wrapContentSize()
                .clickable { NavController.navigate("detalle/${item.id}") }
        ) {
            imgCard(item)
        }
    }
}

@Composable
fun imgCard(
    item: Pokemones
){

    //Variable para cambiar el color de fondo
    val backgroundColor = when(item.type){
        "water","flying" -> Color.Blue
        "fire" -> Color.Red
        "grass" -> Color.Green
        "electric" -> Color.Yellow
        "poison" -> Color.Magenta
        "psychic","bug","normal" -> Color.Gray
        else -> Color.LightGray
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ){
        AsyncImage(model = item.imageUrl, contentDescription = item.name)
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = item.name.toUpperCase(),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                Text(
                    text = item.type.toUpperCase(),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}