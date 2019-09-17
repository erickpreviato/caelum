package br.com.caelum.twittelumapp.viewmodel

import androidx.lifecycle.ViewModel
import br.com.caelum.twittelumapp.modelo.Tweet
import br.com.caelum.twittelumapp.repository.TweetRepository

class TweetViewModel(private val repositorio: TweetRepository) : ViewModel() {

    fun lista() = repositorio.list()

    fun salva(tweet: Tweet) = repositorio.salva(tweet)
    fun deleta(tweet: Tweet) = repositorio.deleta(tweet)
}