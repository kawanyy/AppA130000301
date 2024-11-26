package br.edu.up.tarefas.componentes
import androidx.compose.material3.Button // Certifique-se de importar o Button correto
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Botao(
    onClick: () -> Unit,
    modifier: Modifier = Modifier, // Valor padrão para evitar erro se não for passado
    texto : String
) {
    Button(
        onClick = onClick, // Corrigido aqui
        modifier = modifier, // Corrigido aqui
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red, // Cor de fundo do botão
            contentColor = Color.White // Cor do texto
        )
    ) {
        Text(
            text = "Salvar",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )



    }
}