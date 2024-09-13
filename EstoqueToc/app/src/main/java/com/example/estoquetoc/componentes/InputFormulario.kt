package com.example.estoquetoc.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun InputFormulario(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = labelText,
                textAlign = TextAlign.Start,
                fontSize = 14.sp
            )
        }
    )
}