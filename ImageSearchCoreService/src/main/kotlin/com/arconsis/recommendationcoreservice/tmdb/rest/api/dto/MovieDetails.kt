package com.arconsis.recommendationcoreservice.tmdb.rest.api.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieDetails(
    val adult: Boolean,
    @JsonProperty("backdrop_path")
    val backdropPath: String?,
    @JsonProperty("belongs_to_collection")
    val belongsToCollection: MovieCollection?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Long,
    @JsonProperty("imdb_id")
    val imdbId: Long?,
    @JsonProperty("original_language")
    val originalLanguage: String,
    @JsonProperty("original_title")
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    @JsonProperty("poster_path")
    val posterPath: String?,
    @JsonProperty("production_companies")
    val productionCompanies: List<Company>,
    @JsonProperty("production_countries")
    val productionCountries: List<Country>,
    @JsonProperty("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int?,
    @JsonProperty("spoken_languages")
    val spokenLanguages: List<Language>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    @JsonProperty("vote_average")
    val voteAverage: Double,
    @JsonProperty("vote_count")
    val voteCount: Int
)
