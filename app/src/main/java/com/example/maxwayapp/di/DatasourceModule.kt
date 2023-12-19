package com.example.maxwayapp.di

import com.example.maxwayapp.datasource.Datasource
import com.example.maxwayapp.datasource.DatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatasourceModule {

    @Singleton
    @Binds
    fun BindDatasource(datasourceImpl: DatasourceImpl):Datasource
}