package com.example.maxwayapp.data.api

import com.example.maxwayapp.domain.entity.CategoryWhithProducts
import com.example.maxwayapp.domain.product.productDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("v1/core/get/category-with-products/")
    suspend fun getCategoryWhithProducts():Response<CategoryWhithProducts>
    @GET("v1/core/get/product-detail/{id}")
    suspend fun getProductDetail(@Path("id") id: String ):Response<productDetail>

}