package com.example.maxwayapp.di

import com.example.maxwayapp.data.repo.Repository
import com.example.maxwayapp.data.repo.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun BindRepository(repositoryImpl: RepositoryImpl):Repository
}