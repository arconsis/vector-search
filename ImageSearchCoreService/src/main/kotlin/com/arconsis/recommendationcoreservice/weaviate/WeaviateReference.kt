package com.arconsis.recommendationcoreservice.weaviate

private const val MOVIE_CLASS = "Movie"
private const val MOVIE_RELATION_FIELD = "poster"

private const val MOVIE_POSTER_CLASS = "MoviePoster"
private const val MOVIE_POSTER_RELATION_FIELD = "movie"

data class WeaviateReference(val relationName: String, val relationSourceClass: String, val relationTargetClass: String)

object MovieReferences {
    val movieToPosterReference = WeaviateReference(
        relationSourceClass = MOVIE_CLASS,
        relationTargetClass = MOVIE_POSTER_CLASS,
        relationName = MOVIE_RELATION_FIELD,
    )

    val posterToMovieReference = WeaviateReference(
        relationSourceClass = MOVIE_POSTER_CLASS,
        relationTargetClass = MOVIE_CLASS,
        relationName = MOVIE_POSTER_RELATION_FIELD,
    )
}

