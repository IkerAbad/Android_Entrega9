package com.jesuitasrioja.android_entrega9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.jesuitasrioja.android_entrega9.databinding.ActivityMainBinding
import com.jesuitasrioja.android_entrega9.model.SongDao
import com.jesuitasrioja.android_entrega9.model.SongDatabase

class MainActivity : AppCompatActivity() {

    lateinit var songDao: SongDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Get or create (if not created yet) DataBase instance and get its DAO
        songDao = SongDatabase.getInstance(applicationContext).songDao()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_delete -> {
                songDao.deleteAllSongs()
            }
        }
        return true
    }
}