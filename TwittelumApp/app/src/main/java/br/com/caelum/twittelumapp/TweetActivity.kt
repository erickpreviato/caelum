package br.com.caelum.twittelumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.caelum.twittelumapp.bancodedados.TwittelumDatabase
import br.com.caelum.twittelumapp.dao.TweetDao
import br.com.caelum.twittelumapp.modelo.Tweet
import kotlinx.android.synthetic.main.activity_tweet.*

class TweetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tweet_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_salvar -> {
                publicaTweet()
            }
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun publicaTweet() {
        val mensagem = mensagem.text.toString()
        val tweet = Tweet(mensagem)

        val tweetDao = TwittelumDatabase.getInstance(this).tweetDao()
        tweetDao.salva(tweet)
        Toast.makeText(this, "$tweet foi salvo", Toast.LENGTH_LONG).show()
        finish()
    }

}
