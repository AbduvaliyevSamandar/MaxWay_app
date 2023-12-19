package com.example.maxwayapp.datasource

import com.example.maxwayapp.data.api.Api
import com.example.maxwayapp.domain.entity.CategoryWhithProducts
import com.example.maxwayapp.domain.product.productDetail
import retrofit2.Response
import javax.inject.Inject

class DatasourceImpl @Inject constructor(
private val api: Api
) :Datasource {
    override suspend fun getCategoryWhithProducts(): Response<CategoryWhithProducts> {
        return api.getCategoryWhithProducts()
    }

    override suspend fun getProductDetail(id:String): Response<productDetail> {
        return api.getProductDetail(id)
    }
}