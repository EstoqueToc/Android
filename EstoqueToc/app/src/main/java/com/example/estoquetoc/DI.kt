package com.example.estoquetoc

import com.example.estoquetoc.impl.FornecedorRepositoryImpl
import com.example.estoquetoc.impl.FuncionarioRepositoryImpl
import com.example.estoquetoc.impl.LoginRepositoryImpl
import com.example.estoquetoc.repositoy.LoginRepository
import com.example.estoquetoc.repositoy.FornecedorRepository
import com.example.estoquetoc.repositoy.FuncionarioRepository
import com.example.estoquetoc.service.FornecedorService
import com.example.estoquetoc.service.FuncionarioService
import com.example.estoquetoc.service.LoginService
import com.example.estoquetoc.viewModel.FornecedorViewModel
import com.example.estoquetoc.viewModel.FuncionarioViewModel
import com.example.estoquetoc.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<LoginService> {
        Rest.service
    }
    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }

    viewModel<LoginViewModel> {
        LoginViewModel(get())
    }

    single<FornecedorService> {
        Rest.serviceFornecedor
    }

    single<FornecedorRepository> {
        FornecedorRepositoryImpl(get())
    }

    viewModel<FornecedorViewModel> {
        FornecedorViewModel(get())
    }

    single<FuncionarioService> {
        Rest.serviceFuncionario
    }

    single<FuncionarioRepository> {
        FuncionarioRepositoryImpl(get())
    }

    viewModel<FuncionarioViewModel> {
        FuncionarioViewModel(get())
    }
}