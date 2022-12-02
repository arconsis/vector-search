package com.arconsis.recommendationcoreservice.weaviate

import com.arconsis.recommendationcoreservice.data.content.MovieDetails
import com.arconsis.recommendationcoreservice.data.recommendation.MovieRecommendations
import com.arconsis.recommendationcoreservice.data.search.MovieRequest
import com.arconsis.recommendationcoreservice.dataimport.UpdateService
import com.arconsis.recommendationcoreservice.recommendation.MovieRecommendationService
import com.arconsis.recommendationcoreservice.weaviate.client.WeaviateService
import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviateMovieDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviatePosterDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.reference.WeaviateReferenceHolder
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeaviateMovieService(
    private val weaviateService: WeaviateService,
) : MovieRecommendationService,
    UpdateService {

    val movieObjects: MutableList<WeaviateMovieDataHolder> = mutableListOf()
    val posterObjects: MutableList<WeaviatePosterDataHolder> = mutableListOf()
    val references: MutableList<WeaviateReferenceHolder> = mutableListOf()

    override fun getSimilarMovies(request: MovieRequest): MovieRecommendations {
        TODO("Not yet implemented")
    }

    override fun getLatestMovieId(): Int {
        TODO("Not yet implemented")
    }

    override fun addMovieToBatch(movie: MovieDetails, batchSize: Int) {
        val movieObject = movie.toWeaviateMovieObject()

        movieObjects.add(movieObject)

        val posterObject = movie.toWeaviatePosterObject()

        if (posterObject != null) {
            val movieReference = movieObject.referenceTo(posterObject)
            val posterReference = posterObject.referenceTo(movieObject)

            posterObjects.add(posterObject)
            references.add(movieReference)
            references.add(posterReference)
        }

        if (movieObjects.size >= batchSize) {
            flush()
        }
    }

    override fun flush() {
        val objects = arrayOf(*movieObjects.toTypedArray(), *posterObjects.toTypedArray())

        weaviateService.batchUploadObjects(objects)
        weaviateService.batchUploadReferences(references.toTypedArray())

        movieObjects.clear()
        posterObjects.clear()
        references.clear()
    }
}