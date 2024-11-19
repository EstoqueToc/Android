package com.example.estoquetoc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.aula_2609.home.IObterMusicasUseCase
import com.example.aula_2609.home.presentation.stateholders.MainStateHolder
import com.example.aula_2609.home.presentation.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.whenever
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

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
