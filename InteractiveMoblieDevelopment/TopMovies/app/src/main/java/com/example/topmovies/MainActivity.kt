package com.example.topmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var topMovies: MutableList<Movie>
    //lateinit var adapter: MovieAdapter
    lateinit var adapter: MovieListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topMovies = mutableListOf(
            Movie("The Shawshank Redemption", 1994, 9.3),
            Movie("The Godfather", 1972, 9.2),
           /* Movie("The Dark Knight", 2008, 9.0),
            Movie("The Godfather: Part II", 1974, 9.0),
            Movie("Pulp Fiction", 1994, 8.9),
            Movie("Schindler's List", 1993, 8.9),
            Movie("The Lord of the Rings: The Return of the King", 2003, 8.9),
            Movie("12 Angry Men", 1957, 8.9),
            Movie("Inception", 2010, 8.8),*/
            Movie("Fight Club", 1999, 8.8)
        )

        var rvMovies :RecyclerView= findViewById(R.id.rvMovies);
        rvMovies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        listAdapter = MovieListAdapter(this)
        rvMovies.adapter = listAdapter()
        //adapter = MovieAdapter(topMovies)
        listAdapter.submitList(topMovies)
    }

    fun addMovie(v: View){

        topMovies.add(Movie("New movie", 2023, 5.0))

        //adapter.notifyItemInserted(topMovies.size)

        adapter.submitList(topMovies.toList())

    }

    override  fun deleteMovie(int){
        topMovies.removeAt(pos)
        listAdapter.submitList(topMovies.toList())
    }


}