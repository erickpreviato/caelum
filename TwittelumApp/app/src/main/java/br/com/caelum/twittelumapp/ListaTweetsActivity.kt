package br.com.caelum.twittelumapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelumapp.bancodedados.TwittelumDatabase
import br.com.caelum.twittelumapp.factory.ViewModelFactory
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.viewmodel.TweetViewModel
import kotlinx.android.synthetic.main.activity_lista_tweets.*

class ListaTweetsActivity : AppCompatActivity() {

    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tweets)

        viewModel.lista().observe(this, observer())

        val listener = AdapterView.OnItemClickListener { parent, view, posicao, id ->
            val tweet = lista_tweets.getItemAtPosition(posicao) as Tweet
            perguntaSePrecisaDeletarEsse(tweet)
        }
        lista_tweets.onItemClickListener = listener

        fab_add.setOnClickListener {
            val intencao = Intent(this, TweetActivity::class.java)
            startActivity(intencao)
        }
    }

    private fun perguntaSePrecisaDeletarEsse(tweet: Tweet) {
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("Veja bem!!")
            .setMessage("Deseja mesmo apagar esse tweet?")
            .setPositiveButton("Sim") { _, _ -> viewModel.deleta(tweet) }
            .setNegativeButton("Não", null)
            .setNeutralButton("Deixar para depois!", null)
            .show()
    }

    private fun observer(): Observer<List<Tweet>> {
        return Observer {
            lista_tweets.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
        }
    }
}