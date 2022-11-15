package com.blogspot.hellosrinath.mvvm_tmdb.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.hellosrinath.mvvm_tmdb.R
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie
import com.blogspot.hellosrinath.mvvm_tmdb.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ArtistAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()
    fun setList(artist: List<Artist>) {
        artistList.clear()
        artistList.addAll(artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.titleTextView.text = artist.name
        binding.descriptionText.text = "Popularity ${artist.popularity}"
        val posterUrl = "https://image.tmdb.org/t/p/w500/${artist.profilePath}"
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}