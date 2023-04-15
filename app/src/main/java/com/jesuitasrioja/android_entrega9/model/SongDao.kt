package com.jesuitasrioja.android_entrega9.model

import androidx.room.*

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSong(vararg song: Song)

    @Query("SELECT * FROM songs")
    fun getAllSongs(): List<Song>

    @Query("DELETE FROM songs")
    fun deleteAllSongs()

    @Query("SELECT * FROM songs ORDER BY year DESC")
    fun getAllUserOrderedByYear(): List<Song>

/*
    @Delete
    fun deleteSong(song: Song)

    @Update
    fun updateSong(song: Song)

    @Query("SELECT * FROM songs WHERE song_title = :title")
    fun getSongByName(song: String): List<Song>

    @Query("SELECT * FROM songs WHERE year = :year")
    fun getUsersByAge(year: Int): List<Song>
*/

}