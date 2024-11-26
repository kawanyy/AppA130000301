package br.edu.up.tarefas.itemlista


import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
//import androidx.compose.ui.node.CanFocusChecker.start
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import br.edu.up.tarefas.R
import br.edu.up.tarefas.model.Tarefa
import br.edu.up.tarefas.repositorio.TarefasRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarefaItem(
    position: Int,
    listaTarefas: MutableList<Tarefa>,
    context : Context,
    navController: NavController
) {

    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao


    val scope = rememberCoroutineScope()
    val tarefasRepositorio = TarefasRepositorio()

    fun dialogDeletar(){

        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deletar tarefa")
            .setMessage("Deseja excluir a tarefa?")
            .setPositiveButton("sim"){ _, _ ->
                tarefasRepositorio.deletarTarefa(tituloTarefa.toString())
                scope.launch (Dispatchers.Main){
                    listaTarefas.removeAt(position)
                    navController.navigate("ListaTarefas")
                    Toast.makeText(context, "Sucesso ao deletar tarefa!", Toast.LENGTH_SHORT).show()
                }

            }
            .setNegativeButton("não"){ _, _ ->

            }
            .show()
    }


    Spacer(modifier = Modifier.padding(25.dp))

    Card(
        //backgroundColor = WHITE,
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtTitulo,txtDescricao,btDeletar) = createRefs()

            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top,margin = 10.dp )
                    start.linkTo(parent.start,margin = 10.dp)
                }
            )
            Text(
                text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom,margin = 10.dp )
                    start.linkTo(parent.start,margin = 10.dp)
                }
            )


        }

        IconButton(
            onClick = {
                dialogDeletar()
            }
        ){
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete) , contentDescription = null,
                )
        }

    }
}