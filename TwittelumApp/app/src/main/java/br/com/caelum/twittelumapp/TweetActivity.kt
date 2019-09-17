package br.com.caelum.twittelumapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelumapp.bancodedados.TwittelumDatabase
import br.com.caelum.twittelumapp.dao.TweetDao
import br.com.caelum.twittelumapp.factory.ViewModelFactory
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.viewmodel.TweetViewModel
import kotlinx.android.synthetic.main.activity_tweet.*
import java.io.File

class TweetActivity : AppCompatActivity() {

    private var localFoto: String? = null
    private val viewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

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
            R.id.btn_salvar -> publicaTweet()
            R.id.btn_camera -> tiraFoto()
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun tiraFoto() {
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val caminhoFoto = defineLocalDaFoto()
        camera.putExtra(MediaStore.EXTRA_OUTPUT, caminhoFoto)
        startActivity(camera)
    }

    private fun defineLocalDaFoto(): Uri {
        localFoto = "${getExternalFilesDir("fotos")}/${System.currentTimeMillis()}.jpg"
        val arquivo = File(localFoto)
        return FileProvider.getUriForFile(this, "br.com.caelum.fotos", arquivo)
    }

    private fun publicaTweet() {
        val mensagem = mensagem.text.toString()
        val tweet = Tweet(mensagem)

        viewModel.salva(tweet)
        Toast.makeText(this, "$tweet foi salvo", Toast.LENGTH_LONG).show()
        finish()
    }

}
