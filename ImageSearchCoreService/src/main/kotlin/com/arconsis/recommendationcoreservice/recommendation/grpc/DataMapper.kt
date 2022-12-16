package com.arconsis.recommendationcoreservice.recommendation

import com.arconsis.recommendationcoreservice.MovieFilter
import com.arconsis.recommendationcoreservice.MovieRequest
import com.arconsis.recommendationcoreservice.SearchOptions
import com.arconsis.recommendationcoreservice.data.recommendation.MovieRecommendation
import com.arconsis.recommendationcoreservice.data.recommendation.MovieRecommendations
import kotlin.reflect.jvm.kotlinProperty

fun MovieRequest.toInternal() = com.arconsis.recommendationcoreservice.data.search.MovieRequest(
    imageUrl = imageURL,
    imageData = image,
    filter = filter.toInternal(),
    options = options.toInternal()
)

fun MovieFilter.toInternal() = com.arconsis.recommendationcoreservice.data.search.MovieFilter(description = description, genre = genre)

fun SearchOptions.toInternal() = com.arconsis.recommendationcoreservice.data.search.SearchOptions(minCertainty = minCertainty, maxResults = maxResults)

fun MovieRecommendations.toGrpc(): com.arconsis.recommendationcoreservice.MovieRecommendations {
    val builder = com.arconsis.recommendationcoreservice.MovieRecommendations.newBuilder()

    builder.addAllRecommendations(map { it.toGrpc() })

    return builder.build()
}

fun MovieRecommendation.toGrpc(): com.arconsis.recommendationcoreservice.MovieRecommendation {
    val builder = com.arconsis.recommendationcoreservice.MovieRecommendation.newBuilder()

    builder.movieId = movieId
    builder.certainty = certainty

    return builder.build()
}