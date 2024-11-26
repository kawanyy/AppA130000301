package br.edu.up.tarefas.componentes

import  android.graphics.Color.WHITE
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.edu.up.tarefas.ui.theme.LIGHT_BLUE
//import com.example.tarefas.ui.theme.LIGHT_BLUE
//import java.lang.reflect.Modifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String ) -> Unit,
    modifier: Modifier,
    label : String,
    maxLines: Int,
    keyboardTypes : KeyboardType
){


    OutlinedTextField(
        value = value  ,   //string
        onValueChange, //texto q estou digitando
        modifier,
        label = {
            Text(text = label )

        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            //textColor = BLACK,
            focusedBorderColor = LIGHT_BLUE,  //qnd selecionado muda cor
            focusedLabelColor = LIGHT_BLUE,
            //backgroundColor = WHITE, //cor de fundo
            cursorColor = LIGHT_BLUE
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardTypes
           // keyboardType = keyboardType
        )
    )
}
