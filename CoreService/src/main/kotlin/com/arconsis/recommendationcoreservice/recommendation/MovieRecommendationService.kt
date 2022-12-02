package com.arconsis.recommendationcoreservice.recommendation

import com.arconsis.recommendationcoreservice.data.recommendation.MovieRecommendations
import com.arconsis.recommendationcoreservice.data.search.MovieRequest

interface MovieRecommendationService {
    fun getSimilarMovies(request: MovieRequest): MovieRecommendations
}