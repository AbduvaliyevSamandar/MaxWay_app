package com.example.maxwayapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maxwayapp.data.api.Api
import com.example.maxwayapp.data.state.State
import com.example.maxwayapp.domain.GetCategoryWhithProductUseCase
import com.example.maxwayapp.domain.entity.CategoryWhithProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoryWhithProductUseCase: GetCategoryWhithProductUseCase,

): ViewModel() {

    private val _openSuccesFlow = MutableSharedFlow<CategoryWhithProducts>()
    val openSuccesFlow: SharedFlow<CategoryWhithProducts> = _openSuccesFlow


    private val _errorFlow = MutableStateFlow(0)
    val errorFlow: StateFlow<Int> = _errorFlow

    private val _noNetworkFlow = MutableSharedFlow<Unit>()
    val noNetworkFlow: SharedFlow<Unit> = _noNetworkFlow


    fun getCategoryWhithProduct(){
        viewModelScope.launch {
            val state = getCategoryWhithProductUseCase.invoke()
            hundlerState(state)
        }
    }



    private suspend fun hundlerState(state: State) {
        when(state){
            is State.Error ->_errorFlow.emit(state.code)
            is State.NoNetwork -> _noNetworkFlow.emit(Unit)
            is State.Success<*> -> _openSuccesFlow.emit(state.data as CategoryWhithProducts)
        }

    }

}