package com.nagy.moviesapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nagy.moviesapp.MovieAdapter
import com.nagy.moviesapp.R

class MovieListActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private val movieList = mutableListOf(
        "Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5",
        "Movie 6", "Movie 7", "Movie 8", "Movie 9", "Movie 10"
    )

    private val movieImages = mutableListOf(
        R.drawable.movie1, R.drawable.movie2, R.drawable.movie3,
        R.drawable.movie4, R.drawable.movie5, R.drawable.movie6,
        R.drawable.movie7, R.drawable.movie8, R.drawable.movie9, R.drawable.movie10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val username = intent.getStringExtra("USERNAME") ?: "User"
        title = "Welcome, $username!"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val buttonMore = findViewById<Button>(R.id.buttonMore)

        movieAdapter = MovieAdapter(movieList, movieImages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = movieAdapter

        buttonMore.setOnClickListener {
            val moreMovies = listOf("Movie 11", "Movie 12", "Movie 13", "Movie 14", "Movie 15")
            val moreImages = listOf(
                R.drawable.movie11, R.drawable.movie12, R.drawable.movie13,
                R.drawable.movie14, R.drawable.movie15
            )
            movieAdapter.addMovies(moreMovies, moreImages)
        }
    }

    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.",
        ReplaceWith("finishAffinity()")
    )
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        finishAffinity() // Closes the app
    }
}
