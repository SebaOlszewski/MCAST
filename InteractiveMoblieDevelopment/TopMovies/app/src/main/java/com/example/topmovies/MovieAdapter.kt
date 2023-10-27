package com.example.topmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(var  movies:List<Movie>):RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
       var view = LayoutInflater.from(parent.context)
           .inflate(R.layout.row_movie, parent, false)

        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        with(holder){
            txtvTitle.text = movies[position].title
            txtvYear.text = movies[position].year.toString()
            txtvRating.text = movies[position].rating.toString()
        }

        iBtnDel.setOnClickListener({

            operations.deleteMovie(position)
        })

        /*holder.txtvTitle.text = movies[position].title
        holder.txtvYear.text = movies[position].year.toString()
        holder.txtvRating.text = movies[position].rating.toString()*/
    }

    override fun getItemCount(): Int {
        return movies.size
    }



    inner class MovieHolder (row: View):RecyclerView.ViewHolder(row){

        var txtvTitle: TextView
        var txtvYear: TextView
        var txtvRating: TextView

        init{
            txtvTitle = row.findViewById(R.id.txtvTitle)
            txtvYear = row.findViewById(R.id.txtvYear)
            txtvRating = row.findViewById(R.id.txtvRating)
        }
    }
}