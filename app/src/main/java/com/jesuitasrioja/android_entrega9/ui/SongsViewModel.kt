package com.jesuitasrioja.android_entrega9.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


internal class SongsViewModel : ViewModel() {

    val _listSongs = MutableLiveData<String>()
    // Cambiar al tipo de dato LiveData<String>
    val listSongs: LiveData<String>
    get() = _listSongs
}
