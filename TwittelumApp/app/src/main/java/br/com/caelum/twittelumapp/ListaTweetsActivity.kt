package br.com.caelum.twittelumapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.twittelumapp.bancodedados.TwittelumDatabase
import br.com.caelum.twittelumapp.modelo.Tweet
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_lista_tweets.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tweets)

        fab_add.setOnClickListener {
            val intencao = Intent(this, TweetActivity::class.java)
            startActivity(intencao)
        }
    }

    override fun onResume() {
        super.onResume()
        val tweetDao = TwittelumDatabase.getInstance(this).tweetDao()
        val tweets: List<Tweet> = tweetDao.lista()
        val adapter = ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets)
        lista_tweets.adapter = adapter
    }
}