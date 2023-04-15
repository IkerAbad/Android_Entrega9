package com.jesuitasrioja.android_entrega9.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.jesuitasrioja.android_entrega9.R
import com.jesuitasrioja.android_entrega9.databinding.FragmentAddSongBinding
import com.jesuitasrioja.android_entrega9.databinding.FragmentSongsListBinding
import com.jesuitasrioja.android_entrega9.model.SongDao
import com.jesuitasrioja.android_entrega9.model.SongDatabase

class SongsListFragment : Fragment() {

    private lateinit var binding: FragmentSongsListBinding

    private val viewModel: SongsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSongsListBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        // Get or create (if not created yet) DataBase instance and get its DAO
        binding.listSongs= SongDatabase.getInstance(requireContext()).songDao().getAllSongs().toString()

        binding.buttonAddSong.setOnClickListener{this.findNavController().navigate(R.id.action_songsListFragment_to_addSongFragment)}
        //binding.textViewSongList = listSongs
    }

    //Menu

    //CrearMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    //Funciones del Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            //Mail
            R.id.action_delete -> {
                SongDatabase.getInstance(requireContext()).songDao().deleteAllSongs()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}