package com.arconsis.recommendationcoreservice.dataimport

import com.arconsis.recommendationcoreservice.data.content.MovieDetails

interface UpdateService {

    fun getLatestMovieId(): Int

    fun addMovieToBatch(movie: MovieDetails, batchSize: Int = 20)

    fun flush()
}