package com.example.interviewprep.di

import com.example.interviewprep.data.repository.SearchRepository
import com.example.interviewprep.data.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchRepository(repositoryImpl: SearchRepositoryImpl): SearchRepository
}