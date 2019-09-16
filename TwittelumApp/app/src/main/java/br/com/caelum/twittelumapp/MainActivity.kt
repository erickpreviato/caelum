package br.com.caelum.twittelumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        publicaTweet()
    }

    private fun publicaTweet() {
        btn_publica.setOnClickListener {
            val tweet = mensagem.text.toString()
            Toast.makeText(this, tweet, Toast.LENGTH_LONG).show();
        }
    }
}
