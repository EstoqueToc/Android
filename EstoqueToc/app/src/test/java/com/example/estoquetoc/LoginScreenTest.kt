package com.example.estoquetoc

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `ao preencher email e senha, os campos devem atualizar corretamente`() = runTest  {
        composeTestRule.setContent {
            LoginScreen(navController = rememberNavController())
        }

        val emailField = composeTestRule.onNodeWithText("Email")
        val senhaField = composeTestRule.onNodeWithText("Senha")

        emailField.performTextInput("usuario@exemplo.com")
        senhaField.performTextInput("senha123")

        emailField.assertTextEquals("usuario@exemplo.com")
        senhaField.assertTextEquals("senha123")
    }

    @Test
    fun `botao entrar deve mostrar toast ao clicar com campos vazios`() {
        composeTestRule.setContent {
            LoginScreen(navController = rememberNavController())
        }

        val botaoEntrar = composeTestRule.onNodeWithText("Entrar")

        botaoEntrar.performClick()
    }

    @Test
    fun `botao entrar deve navegar ao preencher campos corretamente`() = runTest  {
        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController)
        }

        val emailField = composeTestRule.onNodeWithText("Email")
        val senhaField = composeTestRule.onNodeWithText("Senha")
        val botaoEntrar = composeTestRule.onNodeWithText("Entrar")

        emailField.performTextInput("usuario@exemplo.com")
        senhaField.performTextInput("senha123")
        botaoEntrar.performClick()
    }

    @Test
    fun `botao esqueci minha senha deve navegar para tela de cadastro`() = runTest {
        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController)
        }

        val botaoEsqueciSenha = composeTestRule.onNodeWithText("Esqueci minha senha")
        botaoEsqueciSenha.performClick()
    }

    @Test
    fun `botao criar conta deve navegar para tela de criacao de conta`() = runTest {
        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController)
        }

        val botaoCriarConta = composeTestRule.onNodeWithText("Clique aqui para criar uma agora.")
        botaoCriarConta.performClick()
    }
}
