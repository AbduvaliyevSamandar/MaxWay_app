package com.example.maxwayapp.datasource

import com.example.maxwayapp.domain.entity.CategoryWhithProducts
import com.example.maxwayapp.domain.product.productDetail
import retrofit2.Response

interface Datasource {

    suspend fun getCategoryWhithProducts():Response<CategoryWhithProducts>
    suspend fun getProductDetail(id:String):Response<productDetail>
}