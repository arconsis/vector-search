package com.arconsis.recommendationcoreservice.recommendation

import com.arconsis.recommendationcoreservice.data.recommendation.MovieRecommendations
import com.arconsis.recommendationcoreservice.data.search.MovieRequest
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RecommendationService(private val productSearchService: MovieRecommendationService) {
    fun recommendationsForRequest(movieRequest: MovieRequest): MovieRecommendations {
        return productSearchService.getSimilarMovies(movieRequest)
    }
}
