package com.flowz.roomdatabasewithkotlin.mvvm_example.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flowz.roomdatabasewithkotlin.mvvm_example.data.QuoteRepository

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return QuoteViewModel(quoteRepository) as T
    }


}