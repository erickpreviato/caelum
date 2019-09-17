package br.com.caelum.twittelumapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.caelum.twittelumapp.modelo.Tweet

@Dao
interface TweetDao {

    @Insert
    fun salva(tweet: Tweet)

    @Query("SELECT * FROM Tweet")
    fun lista(): List<Tweet>
}