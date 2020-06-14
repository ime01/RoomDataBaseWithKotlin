package com.flowz.roomdatabasewithkotlin.mvvm_example.utilities

import com.flowz.roomdatabasewithkotlin.mvvm_example.data.FakeDatabase
import com.flowz.roomdatabasewithkotlin.mvvm_example.data.QuoteRepository
import com.flowz.roomdatabasewithkotlin.mvvm_example.ui.quotes.QuoteViewModel
import com.flowz.roomdatabasewithkotlin.mvvm_example.ui.quotes.QuoteViewModelFactory

object InjectorUtils {

    fun provideQuoteViewModelFactory(): QuoteViewModelFactory{

        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }

}