package com.jesuitasrioja.android_entrega9.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jesuitasrioja.android_entrega9.model.Song
import com.jesuitasrioja.android_entrega9.model.SongDao
import com.jesuitasrioja.android_entrega9.model.SongDatabase
import com.jesuitasrioja.android_entrega9.databinding.FragmentAddSongBinding


class AddSongFragment : Fragment() {

    private lateinit var binding: FragmentAddSongBinding
    lateinit var songDao: SongDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddSongBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get or create (if not created yet) DataBase instance and get its DAO
        songDao = SongDatabase.getInstance(requireContext()).songDao()

        // Set Listener on button to add a new Song
        binding.submit.setOnClickListener {
            addSong()
        }

    }

    private fun addSong() {

        if (allFieldsFilled()) {
            // Instantiate new Song from View Inputs
            val newSong: Song = Song(
                binding.title.text.toString(),
                binding.singer.text.toString(),
                binding.album.text.toString(),
                binding.year.text.toString().toInt()
            )
            // Insert Song into Database
            songDao.insertSong(newSong)

            // Clear View Inputs
            binding.title.setText("")
            binding.singer.setText("")
            binding.album.setText("")
            binding.year.setText("")
        } else {
            Toast.makeText(requireContext(), "fill_fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun allFieldsFilled(): Boolean =
        !(binding.title.text.isNullOrBlank() || binding.singer.text.isNullOrBlank() || binding.album.text.isNullOrBlank() || binding.year.text.isNullOrBlank())
}
