// RGM 30000301 KAWANY MARQUES RAMIRO


package br.edu.up.tarefas.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.tarefas.ui.theme.TarefasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarefasTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "ListaTarefas") {
                    composable(route = "ListaTarefas") {
                        // Passa o navController para o LoginScreen
                        ListaTarefas(navController = navController)
                    }
                    composable(route = "listaTarefas") {
                        ListaTarefas(navController)
                    }
                    composable(route = "salvarTarefa") {
                        SalvarTarefa(navController)
                    }
                }
            }
        }
    }
}
