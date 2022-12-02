package com.arconsis.recommendationcoreservice.data.search

data class MovieRequest(val imageUrl: String, val imageData: String, val filter: MovieFilter, val options: SearchOptions)
