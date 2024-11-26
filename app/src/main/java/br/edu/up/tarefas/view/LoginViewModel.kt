import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun login(onSuccess: () -> Unit, onError: (String) -> Unit) {
        _isLoading.value = true
        // Simulando uma autenticação, substitua por sua lógica real
        if (_email.value == "user@example.com" && _password.value == "password") {
            onSuccess()
        } else {
            onError("Credenciais inválidas.")
        }
        _isLoading.value = false
    }
}
