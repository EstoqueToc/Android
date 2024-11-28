package com.example.estoquetoc

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.google.ar.core.Config
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LoginScreenTestInstrumented {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun loginScreen_deveExibirTodosOsElementos() {
        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule
            .onNodeWithText("Olá,")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Entre com sua conta.")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Email")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Senha")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Entrar")
            .assertIsDisplayed()
    }

    @Test
    fun loginScreen_deveMostrarMensagemErroQuandoCamposVazios() {
        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule
            .onNodeWithText("Entrar")
            .performClick()

        composeTestRule
            .onNodeWithText("Preencha todos os campos")
            .assertIsDisplayed()
    }

    @Test
    fun loginScreen_deveNavegarParaFaturamentoQuandoLoginBemSucedido() {
        // Cria um NavHostController para testes
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.setGraph(0) // Sem gráfico de navegação
        navController.setCurrentDestination("login") // Define o destino inicial

        composeTestRule.setContent {
            LoginScreen(navController = navController)
        }

        // Simula a entrada de dados no formulário
        composeTestRule
            .onNodeWithText("Email")
            .performTextInput("usuario@teste.com")

        composeTestRule
            .onNodeWithText("Senha")
            .performTextInput("123456")

        // Clica no botão de login
        composeTestRule
            .onNodeWithText("Entrar")
            .performClick()

        // Verifica se a navegação ocorreu corretamente
        assert(navController.currentDestination?.route == "faturamento")
    }


    @Test
    fun loginScreen_deveAlternarVisibilidadeSenha() {
        composeTestRule.setContent {
            LoginScreen()
        }

        // Insira a senha no campo
        composeTestRule
            .onNodeWithText("Senha")
            .performTextInput("123456")

        // Clique no botão/ícone de alternar visibilidade
        composeTestRule
            .onNodeWithContentDescription("Alternar visibilidade da senha")
            .performClick()

        // Verificar se a senha visível é exibida (ajustar com base no comportamento real)
        composeTestRule
            .onNodeWithText("123456", substring = true)
            .assertExists()
    }
}