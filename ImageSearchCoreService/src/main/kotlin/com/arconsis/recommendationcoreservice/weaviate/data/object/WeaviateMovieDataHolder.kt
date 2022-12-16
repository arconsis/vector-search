package com.arconsis.recommendationcoreservice.weaviate.data.`object`

import com.arconsis.recommendationcoreservice.common.mapOfNotNullValues


data class WeaviateMovieDataHolder(
    override var id: String,
    val adult: Boolean,
    val collection: String?,
    val budget: Int,
    val genres: List<String>,
    val movieId: Long,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    val productionCompanies: List<String>,
    val productionCountries: List<String>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int?,
    val spokenLanguages: List<String>,
    val status: String,
    val tagline: String?,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
) : WeaviateDataHolder {
    override val className: String = "Movie"

    override val properties: Map<String, Any> = mapOfNotNullValues(
        "adult" to adult,
        "collection" to collection,
        "budget" to budget,
        "genres" to genres,
        "movieId" to movieId,
        "originalLanguage" to originalLanguage,
        "originalTitle" to originalTitle,
        "overview" to overview,
        "popularity" to popularity,
        "productionCompanies" to productionCompanies,
        "productionCountries" to productionCountries,
        "releaseDate" to releaseDate,
        "revenue" to revenue,
        "runtime" to runtime,
        "spokenLanguages" to spokenLanguages,
        "status" to status,
        "tagline" to tagline,
        "title" to title,
        "voteAverage" to voteAverage,
        "voteCount" to voteCount,
    )
}
