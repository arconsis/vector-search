package com.arconsis.recommendationcoreservice.data.content

data class MovieDetails(
    val adult: Boolean,
    val collection: String?,
    val budget: Int,
    val genres: List<String>,
    val homepage: String?,
    val id: Long,
    val imdbId: Long?,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    val poster: String?,
    val productionCompanies: List<String>,
    val productionCountries: List<String>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int?,
    val spokenLanguages: List<String>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
