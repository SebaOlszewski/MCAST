package com.example.topmovies

data class Movie(var title:String, var year:Int, var rating:Double){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (title != other.title) return false
        if (year != other.year) return false
        if (rating != other.rating) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + year
        result = 31 * result + rating.hashCode()
        return result
    }
}



