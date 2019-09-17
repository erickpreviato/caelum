package br.com.caelum.twittelumapp.repository

import br.com.caelum.twittelumapp.dao.TweetDao
import br.com.caelum.twittelumapp.modelo.Tweet

class TweetRepository(private val fonteDeDados: TweetDao) {

    fun list() = fonteDeDados.lista()

    fun salva(tweet: Tweet) = fonteDeDados.salva(tweet)
    fun deleta(tweet: Tweet) = fonteDeDados.deleta(tweet)
}