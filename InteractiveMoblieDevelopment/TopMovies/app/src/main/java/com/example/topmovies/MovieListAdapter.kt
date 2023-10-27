package com.example.topmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter():ListAdapter<Movie, MovieListAdapter.MovieHolder>(MovieDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
       var view = LayoutInflater.from(parent.context)
           .inflate(R.layout.row_movie, parent, false)

        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        with(holder) {
            txtvTitle.text = getItem(position).title
            txtvYear.text = getItem(position).year.toString()
            txtvRating.text = getItem(position).rating.toString()
        }

        iBtnDel.setOnClickListener({



        })

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

    private class MovieDiffUtil : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            //ideally compare id!!!
            return oldItem.title.equals(newItem.title)
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.equals(newItem)
        }

    }

    interface MovieOperations{
        fun deleteMovie(pos:Int)
    }

}