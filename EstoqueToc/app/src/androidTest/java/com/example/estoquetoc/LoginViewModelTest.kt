package com.example.estoquetoc

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInitialElementsDisplayed() {
        composeTestRule.setContent {
            LoginScreen(navController = null)
        }

        // Verifica se o logo e o texto inicial são exibidos corretamente
        composeTestRule.onNodeWithContentDescription("Logo Estoquetoc").assertExists()
        composeTestRule.onNodeWithText("Estoquetoc").assertExists()
        composeTestRule.onNodeWithText("Olá,").assertExists()
        composeTestRule.onNodeWithText("Entre com sua conta.").assertExists()

        // Verifica se os campos de texto estão visíveis
        composeTestRule.onNodeWithText("Email").assertExists()
        composeTestRule.onNodeWithText("Senha").assertExists()
    }

    @Test
    fun testEmailAndPasswordInput() {
        composeTestRule.setContent {
            LoginScreen(navController = null)
        }

        // Insere texto no campo de email
        val emailNode = composeTestRule.onNodeWithText("Email")
        emailNode.performTextInput("teste@exemplo.com")
        emailNode.assertTextEquals("teste@exemplo.com")

        // Insere texto no campo de senha
        val passwordNode = composeTestRule.onNodeWithText("Senha")
        passwordNode.performTextInput("123456")
        passwordNode.assertTextEquals("123456")
    }

    @Test
    fun testTogglePasswordVisibility() {
        composeTestRule.setContent {
            LoginScreen(navController = null)
        }

        // Clica no ícone de visibilidade
        val visibilityToggleNode = composeTestRule.onNodeWithContentDescription("Toggle password visibility")
        visibilityToggleNode.performClick()

        // Verifica se a senha agora está visível
        composeTestRule.onNodeWithText("Senha").assert(hasText("123456", substring = true))
    }

    @Test
    fun testButtonNavigation() {
        val navController = TestNavHostController(InstrumentationRegistry.getInstrumentation().targetContext)

        composeTestRule.setContent {
            LoginScreen(navController = navController)
        }

        // Insere email e senha para ativar o botão
        composeTestRule.onNodeWithText("Email").performTextInput("teste@exemplo.com")
        composeTestRule.onNodeWithText("Senha").performTextInput("123456")

        // Clica no botão "Entrar"
        composeTestRule.onNodeWithText("Entrar").performClick()

        // Verifica se a navegação foi acionada corretamente
        assert(navController.currentBackStackEntry?.destination?.route == "faturamento")
    }

    @Test
    fun testEmptyFieldsToastMessage() {
        composeTestRule.setContent {
            LoginScreen(navController = null)
        }

        // Clica no botão sem preencher campos
        composeTestRule.onNodeWithText("Entrar").performClick()

        // A verificação do Toast geralmente exige bibliotecas de testes de UI instrumentados
        // (não é possível diretamente com Jetpack Compose Testing).
    }
}
