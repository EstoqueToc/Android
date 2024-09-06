package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Produtos() {
    var produto by remember{ mutableStateOf("") }
    Column (

    ){
       Button(onClick = { /*TODO*/ }) {

           Box( ){
               Image(
                   modifier = Modifier.size(20.dp),
                   painter = painterResource(id = R.drawable.img),
                   contentDescription = "Box"
               )
               Text(text = "Produto XX")
           }

       }
    }
}

