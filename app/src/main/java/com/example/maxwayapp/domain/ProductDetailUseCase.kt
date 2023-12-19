package com.example.maxwayapp.domain

import com.example.maxwayapp.data.repo.Repository
import com.example.maxwayapp.data.state.State
import java.io.IOException
import javax.inject.Inject

class ProductDetailUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke( id:String): State {
        try {
            val productDetail = repository.getProductDetail(id).body()
            return State.Success(productDetail)

        }catch (e:Exception){
            if (e is IOException){
                return State.NoNetwork
            }
            return State.Error(1)
        }
    }
}