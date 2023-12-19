package com.example.maxwayapp.data.repo

import com.example.maxwayapp.domain.entity.CategoryWhithProducts
import com.example.maxwayapp.domain.product.productDetail
import retrofit2.Response

interface Repository {

    suspend fun getCategoryWhithProduct():Response<CategoryWhithProducts>
    suspend fun getProductDetail(id:String):Response<productDetail>
}