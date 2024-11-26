package br.edu.up.tarefas.view

import android.annotation.SuppressLint
import android.graphics.Color.WHITE
import android.view.Menu
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.tarefas.componentes.Botao
import br.edu.up.tarefas.componentes.CaixaDeTexto
import br.edu.up.tarefas.repositorio.TarefasRepositorio
import br.edu.up.tarefas.ui.theme.RADIO_BUTTON_GREEN_DISABLED
import br.edu.up.tarefas.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import br.edu.up.tarefas.ui.theme.RADIO_BUTTON_RED_DISABLED
import br.edu.up.tarefas.ui.theme.RADIO_BUTTON_RED_SELECTED
import br.edu.up.tarefas.ui.theme.RADIO_BUTTON_YELLOW_DISABLED
import br.edu.up.tarefas.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//import br.edu.up.tarefas.ui.theme.Purple40


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalvarTarefa(
    navController : NavController
){

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val tarefasRepositorio = TarefasRepositorio()

    Scaffold(
        topBar = {
            TopAppBar( //  backgroundColor = Purple40,
                title = {
                    Text(
                        text = "                       Anotar Pedido",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red // Define a cor vermelha


            )
            )
        }
    ) {

        var tituloTarefa by remember { mutableStateOf("") }

        var descricaoTarefa by remember { mutableStateOf("") }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 200.dp, 20.dp, 0.dp) ,
                label = "Pedido",
                maxLines = 1,
                keyboardTypes = KeyboardType.Text
            )

            CaixaDeTexto(
                value = descricaoTarefa,
                onValueChange = {
                    descricaoTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 30.dp, 20.dp, 0.dp) ,
                label = "Descrição",
                maxLines = 5,
                keyboardTypes = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){

            }

            Botao(
                onClick = {

                    var mensagem = true

                    scope.launch(Dispatchers.IO){
                        if(tituloTarefa.isEmpty()){
                            mensagem = false
                        }else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty()){
                            tarefasRepositorio.salvarTarefa(tituloTarefa,descricaoTarefa)
                            mensagem = true
                        }else if  (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty()){
                            tarefasRepositorio.salvarTarefa(tituloTarefa,descricaoTarefa)
                            mensagem = true
                        }else if  (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty()) {
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty()&& descricaoTarefa.isNotEmpty()){
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() ) {
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty()) {
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty()) {
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa)
                            mensagem = true
                        }else {
                            tarefasRepositorio.salvarTarefa(tituloTarefa, descricaoTarefa)
                            mensagem = true
                        }
                    }

                    scope.launch(Dispatchers.Main){
                        if (mensagem) {
                            Toast.makeText(context, "Sucesso ao salvar a tarefa!", Toast.LENGTH_SHORT).show()
                            navController.popBackStack() //volta a tela anterior
                        }else{
                            Toast.makeText(context, "Titulo da terefa é obrigatório", Toast.LENGTH_SHORT).show()
                        }
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                texto = "Salvar"
            )



        }

    }

}