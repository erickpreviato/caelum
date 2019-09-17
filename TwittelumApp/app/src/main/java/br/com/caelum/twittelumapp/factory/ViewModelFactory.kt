package br.com.caelum.twittelumapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.caelum.twittelumapp.application.TwittelumApplication
import br.com.caelum.twittelumapp.bancodedados.TwittelumDatabase
import br.com.caelum.twittelumapp.repository.TweetRepository
import br.com.caelum.twittelumapp.viewmodel.TweetViewModel

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun repositorio() = TweetRepository(Injector.tweetDao())

    override fun <T : ViewModel?> create(modelClass: Class<T>) = TweetViewModel(repositorio()) as T

    object Injector {
        private val contexto = TwittelumApplication.getInstance()
        private val database = TwittelumDatabase.getInstance(contexto)
        fun tweetDao() = database.tweetDao()
    }
}