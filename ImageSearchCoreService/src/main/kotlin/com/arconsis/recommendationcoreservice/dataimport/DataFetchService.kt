package com.arconsis.recommendationcoreservice.dataimport

import com.arconsis.recommendationcoreservice.data.content.MovieDetails

interface DataFetchService {
    fun getAvailableMovieIds(): List<Long>

    fun getMovie(movieId: Long): MovieDetails
}