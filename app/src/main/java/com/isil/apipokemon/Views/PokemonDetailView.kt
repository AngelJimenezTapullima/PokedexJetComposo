package com.isil.apipokemon.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableInferredTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.isil.apipokemon.Models.PokemonDetalle
import com.isil.apipokemon.ViewModel.PokemonViewModel

@Composable
fun PokemonDetailView(NavController: NavHostController, viewModel: PokemonViewModel, id: Int) {
    val pokemon = viewModel
    pokemon.id = id
    pokemon.mostrarPokemonbyId()
    val detalle = pokemon.state.detallePokemon

    //Variable para cambiar el color de fondo
    val backgroundColor = when(detalle.type){
        "water","flying" -> Color.Blue
        "fire" -> Color.Red
        "grass" -> Color.Green
        "electric" -> Color.Yellow
        "poison" -> Color.Magenta
        "psychic","bug","normal" -> Color.Gray
        else -> Color.LightGray
    }

    Scaffold(
        topBar = { TopBarDetalle(NavController, detalle = detalle) },
        content = { innerpadding ->
            Surface(modifier = Modifier.padding(innerpadding)) {
                ContenidoDetalle(
                    NavController = NavController,
                    viewModel = viewModel,
                    detalle = detalle,
                    color = backgroundColor
                )
            }
        },
        containerColor = backgroundColor
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDetalle(NavController: NavHostController, detalle: PokemonDetalle) {
    CenterAlignedTopAppBar(
        colors = topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                TextoSemiBold(texto = detalle.name.toUpperCase())
            }
        },
        navigationIcon = {
            IconButton(onClick = { NavController.navigate("pokemons") }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
            }
        }

    )
}

@Composable
fun ContenidoDetalle(
    NavController: NavHostController,
    viewModel: PokemonViewModel,
    detalle: PokemonDetalle,
    color: Color
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color)
    ){
        AsyncImage(
            model = detalle.imageUrl,
            contentDescription = detalle.name,
            modifier = Modifier
                .height(300.dp)
        )
        Tipo(texto = detalle.type)
        TextoDetalle(detalle.description)
        Estadisticas(detalle = detalle ,color = color)
    }
}

@Composable
fun TextoDetalle(texto: String){
    Text(
        text = texto,
        color = Color.White,
        modifier = Modifier
            .padding(20.dp)
    )
}

@Composable
fun Tipo(texto: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "Tipo",
            letterSpacing = 1.sp,
            color = Color.White
        )
        Text(
            text = texto.toUpperCase(),
            fontSize = 20.sp,
            letterSpacing = 2.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@Composable
fun TextoSemiBold(texto: String){
    Text(
        text = texto,
        fontSize = 20.sp,
        letterSpacing = 2.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.White
    )
}

@Composable
fun Estadisticas(
    detalle: PokemonDetalle,
    color: Color
){
    Box(contentAlignment = Alignment.Center){
        Row() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                    .height(60.dp)
                    .width(170.dp)
                    .background(Color.Blue)
            ) {
                TextoSemiBold(texto = "Attack: "+detalle.attack)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
                    .height(60.dp)
                    .width(170.dp)
                    .background(Color.Green)
            ) {
                TextoSemiBold(texto = "Defense: "+detalle.defense)
            }
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color)
                .size(45.dp)
        )
    }
}