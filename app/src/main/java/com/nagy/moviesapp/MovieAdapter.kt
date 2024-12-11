package com.nagy.moviesapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
    private val movies: MutableList<String>,
    private val images: MutableList<Int>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = movies[position]
        holder.movieImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int = movies.size


    @SuppressLint("NotifyDataSetChanged")
    fun addMovies(newMovies: List<String>, newImages: List<Int>) {
        movies.addAll(newMovies)
        images.addAll(newImages)
        notifyDataSetChanged()
    }
}
