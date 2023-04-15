package com.jesuitasrioja.android_entrega9.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class Song(
    @ColumnInfo(name = "song_title")
    val title: String,
    @ColumnInfo(name = "singer_band")
    val singer: String,
    @ColumnInfo(name = "album_name")
    val album: String,
    val year: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
