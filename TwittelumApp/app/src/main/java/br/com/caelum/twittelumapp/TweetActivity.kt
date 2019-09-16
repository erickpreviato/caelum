package br.com.caelum.twittelumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tweet.*

class TweetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet)

        btn_publica.setOnClickListener {
            publicaTweet()
            finish()
        }
    }

    private fun publicaTweet() {
        val tweet = mensagem.text.toString()
        Toast.makeText(this, tweet, Toast.LENGTH_LONG).show()
    }
}
