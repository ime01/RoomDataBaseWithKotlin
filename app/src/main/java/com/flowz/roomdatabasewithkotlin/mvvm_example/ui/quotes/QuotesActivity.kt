package com.flowz.roomdatabasewithkotlin.mvvm_example.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.flowz.roomdatabasewithkotlin.R
import com.flowz.roomdatabasewithkotlin.mvvm_example.data.Quote
import com.flowz.roomdatabasewithkotlin.mvvm_example.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuoteViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(QuoteViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes->

            val stringBuilder = StringBuilder()
            quotes.forEach {quote->
                stringBuilder.append("$quote\n\n")
            }
            display_text.text = stringBuilder.toString()

        })

        button_add.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
