package com.example.estoquetoc

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLoginButtonTriggersViewModel() {
        // Mock do ViewModel
        val viewModel: LoginViewModel = mock()
        val navController = TestNavHostController(InstrumentationRegistry.getInstrumentation().targetContext)

        composeTestRule.setContent {
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        // Simula clique no botão "Entrar"
        composeTestRule.onNodeWithText("Entrar").performClick()

        // Verifica se o método de login foi chamado no ViewModel
        verify(viewModel).login("", "") // ou valores reais simulados
    }
}
