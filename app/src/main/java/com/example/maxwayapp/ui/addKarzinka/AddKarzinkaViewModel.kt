package com.example.maxwayapp.ui.addKarzinka

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maxwayapp.data.state.State
import com.example.maxwayapp.domain.ProductDetailUseCase
import com.example.maxwayapp.domain.entity.CategoryWhithProducts
import com.example.maxwayapp.domain.product.productDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddKarzinkaViewModel @Inject constructor(
    private val productDetailUseCase: ProductDetailUseCase
) :ViewModel(){

    private val _openSuccesFlow = MutableSharedFlow<productDetail>()
    val openSuccesFlow: SharedFlow<productDetail> = _openSuccesFlow


    private val _errorFlow = MutableStateFlow(0)
    val errorFlow: StateFlow<Int> = _errorFlow

    private val _noNetworkFlow = MutableSharedFlow<Unit>()
    val noNetworkFlow: SharedFlow<Unit> = _noNetworkFlow

    fun productDetail(id:String){
        viewModelScope.launch {
            val state = productDetailUseCase.invoke(id)
            hundlerState(state)
        }
    }



    private suspend fun hundlerState(state: State) {
        when(state){
            is State.Error ->_errorFlow.emit(state.code)
            is State.NoNetwork -> _noNetworkFlow.emit(Unit)
            is State.Success<*> -> _openSuccesFlow.emit(state.data as productDetail)
        }

    }

}