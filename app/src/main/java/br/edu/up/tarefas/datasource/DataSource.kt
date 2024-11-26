package br.edu.up.tarefas.datasource

import br.edu.up.tarefas.model.Tarefa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DataSource {


    private val db = FirebaseFirestore.getInstance()

    private val _todastarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    val todastarefas: StateFlow<MutableList<Tarefa>> = _todastarefas.asStateFlow()

    fun salvarTarefa(tarefa: String, descricao: String) {

        val tarefaMap = hashMapOf(
            "tarefa" to tarefa,
            "descricao" to descricao
        )
        db.collection("tarefas").document(tarefa).set(tarefaMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>> {


        val listaTarefas: MutableList<Tarefa> = mutableListOf()


        db.collection("tarefas").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful) {
                for (documento in querySnapshot.result) {
                    val tarefa = documento.toObject(Tarefa::class.java)
                    listaTarefas.add(tarefa)
                    _todastarefas.value = listaTarefas
                }
            }

        }

        return todastarefas
    }

    fun deletarTarefa(tarefa: String) {
        db.collection("tarefas").document(tarefa).delete().addOnCompleteListener {

        }.addOnFailureListener {

        }
    }
}




