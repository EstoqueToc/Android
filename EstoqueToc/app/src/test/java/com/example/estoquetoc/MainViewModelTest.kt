package com.example.aula_2609


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

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRole = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var observer: Observer<MainStateHolder>

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var obterMusicasUseCase: IObterMusicasUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(
            obterMusicasUseCase = obterMusicasUseCase
        )
        viewModel.uiState.observeForever(observer)
    }

    @After
    fun tearDown() {
        viewModel.uiState.removeObserver(observer)
        Dispatchers.resetMain()
    }

    @Test
    fun `Ao carregar as musicas o estado deve deixar de ser Loadind`() = runTest {
        viewModel.carregarLista()
        Assert.assertTrue(viewModel.uiState.value !is MainStateHolder.Loading)
    }

    @Test
    fun `Ao carregar as musicas o estado deve deixar de ser Loading`() = runTest {
        // Mockando a resposta do UseCase
        whenever(obterMusicasUseCase()).thenReturn(Result.success(emptyList()))

        // Carregando a lista
        viewModel.carregarLista()
        advanceUntilIdle()

        // Verificando se o estado não é mais "Loading"
        Assert.assertTrue(viewModel.uiState.value !is MainStateHolder.Loading)
    }

    @Test
    fun `Ao carregar as musicas o estado deve ser Content`() = runTest {
        // Mockando o UseCase para retornar uma lista de músicas
        whenever(obterMusicasUseCase()).thenReturn(Result.success(emptyList()))

        // Carregando a lista
        viewModel.carregarLista()
        advanceUntilIdle()

        // Verificando se o estado é Content
        Assert.assertTrue(viewModel.uiState.value is MainStateHolder.Content)
    }

    @Test
    fun `Ao falhar ao carregar as musicas o estado deve ser Error`() = runTest {
        // Simulando falha na obtenção das músicas
        whenever(obterMusicasUseCase()).thenReturn(Result.failure(Exception("Erro ao carregar músicas")))

        // Carregando as músicas
        viewModel.carregarLista()
        advanceUntilIdle()

        // Verificando se o estado da UI é Error e a mensagem é a esperada
        val errorState = viewModel.uiState.value as? MainStateHolder.Error
        Assert.assertEquals("Deu ruim ...", errorState?.message)
    }

    @Test
    fun `Ao carregar lista vazia o estado deve ser Content com lista vazia`() = runTest {
        // Simulando o retorno de uma lista vazia
        whenever(obterMusicasUseCase()).thenReturn(Result.success(emptyList()))

        // Carregando a lista
        viewModel.carregarLista()
        advanceUntilIdle()

        // Verificando se o estado é Content e a lista está vazia
        val contentState = viewModel.uiState.value as MainStateHolder.Content
        Assert.assertTrue(contentState.data.isEmpty())
    }

}

