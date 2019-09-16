package br.com.caelum.twittelumapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_lista_tweets.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tweets)

        val tweets: List<String> = listOf("Tweet 1", "Outro Tweet", "Mais um Tweet")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tweets)
        lista_tweets.adapter = adapter

        fab_add.setOnClickListener { Snackbar.make(lista_tweets, "Carregando...", Snackbar.LENGTH_SHORT).show() }
    }
}