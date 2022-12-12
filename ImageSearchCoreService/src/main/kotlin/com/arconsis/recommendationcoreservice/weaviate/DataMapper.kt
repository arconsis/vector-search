package com.arconsis.recommendationcoreservice.weaviate

import com.arconsis.recommendationcoreservice.data.content.MovieDetails
import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviateMovieDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviatePosterDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.reference.WeaviateReferenceHolder
import java.util.*

fun MovieDetails.toWeaviateMovieObject() = WeaviateMovieDataHolder(
    id = UUID.randomUUID().toString(),
    adult = adult,
    collection = collection,
    budget = budget,
    genres = genres,
    movieId = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    productionCompanies = productionCompanies,
    productionCountries = productionCountries,
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages,
    status = status,
    tagline = tagline,
    title = title,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun MovieDetails.toWeaviatePosterObject(): WeaviatePosterDataHolder? {
    return if (poster != null) {
        WeaviatePosterDataHolder(id = UUID.randomUUID().toString(), image = poster)
    } else {
        null
    }
}

fun WeaviateMovieDataHolder.referenceTo(posterObject: WeaviatePosterDataHolder): WeaviateReferenceHolder {
    val reference = MovieReferences.movieToPosterReference

    return WeaviateReferenceHolder(reference.relationSourceClass, id, reference.relationName, reference.relationTargetClass, posterObject.id)
}

fun WeaviatePosterDataHolder.referenceTo(movieObject: WeaviateMovieDataHolder): WeaviateReferenceHolder {
    val reference = MovieReferences.posterToMovieReference

    return WeaviateReferenceHolder(reference.relationSourceClass, id, reference.relationName, reference.relationTargetClass, movieObject.id)
}
