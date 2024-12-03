package com.example.estoquetoc

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.ar.core.Config
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginScreenTestInstrumented {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginScreen_deveExibirTodosOsElementos() {
        composeTestRule.setContent {
            LoginScreen()
        }

        // Teste básico para verificar elementos principais
        composeTestRule.onNodeWithText("Olá,", substring = true).assertExists()
        composeTestRule.onNodeWithText("Entre com sua conta.").assertExists()
        composeTestRule.onNodeWithText("Email").assertExists()
        composeTestRule.onNodeWithText("Senha").assertExists()
        composeTestRule.onNodeWithText("Entrar").assertExists()
    }

    @Test
    fun loginScreen_deveMostrarMensagemErroQuandoCamposVazios() {
        composeTestRule.setContent {
            LoginScreen()
        }

        // Simula o clique no botão "Entrar" com campos vazios
        composeTestRule.onNodeWithText("Entrar").performClick()

        // Verifica se a mensagem de erro aparece
        composeTestRule.onNodeWithText("Preencha todos os campos").assertExists()
    }

    @Test
    fun loginScreen_deveAlternarVisibilidadeSenha() {
        composeTestRule.setContent {
            LoginScreen()
        }

        // Insere a senha no campo
        composeTestRule.onNodeWithText("Senha").performTextInput("123456")

        // Alterna a visibilidade da senha
        composeTestRule.onNodeWithContentDescription("Alternar visibilidade da senha").performClick()

        // Verifica se a senha visível é exibida (ajuste conforme necessário)
        composeTestRule.onNodeWithText("123456", substring = true).assertExists()
    }
}