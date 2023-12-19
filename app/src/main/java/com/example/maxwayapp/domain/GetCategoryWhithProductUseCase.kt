package com.example.maxwayapp.domain

import com.example.maxwayapp.data.repo.Repository
import com.example.maxwayapp.data.state.State
import java.io.IOException
import javax.inject.Inject

class GetCategoryWhithProductUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke():State{

        try {
            val categoryWhithProducts = repository.getCategoryWhithProduct().body()
            return State.Success(categoryWhithProducts)

        }catch (e:Exception){
            if (e is IOException){
                return State.NoNetwork
            }
            return State.Error(1)
        }
    }
}