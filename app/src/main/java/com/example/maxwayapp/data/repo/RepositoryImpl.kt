package com.example.maxwayapp.data.repo

import com.example.maxwayapp.datasource.Datasource
import com.example.maxwayapp.domain.entity.CategoryWhithProducts
import com.example.maxwayapp.domain.product.productDetail
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val datasource: Datasource
) :Repository{
    override suspend fun getCategoryWhithProduct(): Response<CategoryWhithProducts> {
        return datasource.getCategoryWhithProducts()
    }

    override suspend fun getProductDetail(id:String): Response<productDetail> {
        return datasource.getProductDetail(id)
    }
}