package com.flowz.roomdatabasewithkotlin.mvvm_example.ui.quotes

import androidx.lifecycle.ViewModel
import com.flowz.roomdatabasewithkotlin.mvvm_example.data.Quote
import com.flowz.roomdatabasewithkotlin.mvvm_example.data.QuoteRepository

class QuoteViewModel (private val quoteRepository: QuoteRepository):ViewModel(){

    fun getQuotes () = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)






}