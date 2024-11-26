package br.edu.up.tarefas.repositorio

import br.edu.up.tarefas.datasource.DataSource
import br.edu.up.tarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow


class TarefasRepositorio (){

    private val dataSource = DataSource()

    fun salvarTarefa(tarefa: String, descricao: String){
        dataSource.salvarTarefa(tarefa, descricao)
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>> {
        return dataSource.recuperarTarefas()
    }

    fun deletarTarefa(tarefa: String){
        dataSource.deletarTarefa(tarefa)
    }

}