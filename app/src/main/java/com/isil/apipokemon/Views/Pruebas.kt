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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.isil.apipokemon.ViewModel.PokemonViewModel

@Composable
fun Pruebas(NavController: NavHostController, viewModel: PokemonViewModel) {
    val texto = "poison"
    val numero = 40
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5F5DB6))
//            .height(300.dp)
//            .width(200.dp)
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
                    TextoSemiBold(texto = "Attack: "+numero)
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
                    TextoSemiBold(texto = "Defense: "+numero)
                }
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF5F5DB6))
                    .size(45.dp)
            )
        }
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ){
//            Text(
//                text = "Tipo",
//                letterSpacing = 1.sp,
//                color = Color.White
//            )
//            Text(
//                text = texto.toUpperCase(),
//                fontSize = 20.sp,
//                letterSpacing = 2.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = Color.White
//            )
//        }
//        Card(
//            elevation = CardDefaults.cardElevation(20.dp),
//            onClick = { /*TODO*/ },
//            modifier = Modifier
//                .wrapContentSize()
//        ) {
//            imgCardp()
//        }
    }

}

@Composable
fun imgCardp(){
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
    ){
//        Image(
//            painter = painterResource(id = R.drawable.tienda),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxSize()
//                .clip(RoundedCornerShape(20.dp)),
//            contentScale = ContentScale.Crop
//        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Text(
                text = "Nombre",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Tipo",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}