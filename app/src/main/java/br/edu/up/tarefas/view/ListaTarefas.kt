package br.edu.up.tarefas.view
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.tarefas.itemlista.TarefaItem
import br.edu.up.tarefas.model.Tarefa
import br.edu.up.tarefas.repositorio.TarefasRepositorio
import com.google.firebase.ktx.Firebase


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController : NavController) {

    val tarefasRepositorio = TarefasRepositorio()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(  //caixa rosa
                title = {
                    Text(
                        text = "               Hamburguers Food",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red // Define a cor vermelha
                )

            )



        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("SalvarTarefa")
                },
                containerColor = Color.Red, // Cor vermelha
                modifier = Modifier
                    .width(375.dp) // Ajusta a largura do botão
                    .height(60.dp), // Ajusta a altura do botão
                contentColor = Color.White // Cor do texto (se necessário)
            ) {
                Text(
                    text = "Novo Pedido", // Texto do botão
                    fontSize = 30.sp, // Tamanho da fonte
                    fontWeight = FontWeight.Bold // Estilo da fonte
                )
            }
        },
        containerColor = Color.White // Cor de fundo da Scaffold
    ) {

        val listaTarefas = tarefasRepositorio.recuperarTarefas().collectAsState(mutableListOf()).value

        LazyColumn {
            itemsIndexed(listaTarefas){position, _, ->
                TarefaItem(position = position, listaTarefas = listaTarefas, context = context, navController = navController )
            }
        }
    }
}