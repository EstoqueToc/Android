import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule() // Para testar LiveData no mesmo thread

    private val observer: Observer<Boolean> = mock() // Observer mockado

    @Test
    fun `login with valid email and password should update state to true`() = runBlockingTest {
        // Arrange
        val viewModel = LoginViewModel()
        viewModel.loginState.observeForever(observer)

        // Act
        viewModel.login("teste@exemplo.com", "123456")

        // Assert
        verify(observer).onChanged(true)
        assertEquals(true, viewModel.loginState.value)
    }

    @Test
    fun `login with empty email or password should update state to false`() = runBlockingTest {
        // Arrange
        val viewModel = LoginViewModel()
        viewModel.loginState.observeForever(observer)

        // Act
        viewModel.login("", "")

        // Assert
        verify(observer).onChanged(false)
        assertEquals(false, viewModel.loginState.value)
    }
}
