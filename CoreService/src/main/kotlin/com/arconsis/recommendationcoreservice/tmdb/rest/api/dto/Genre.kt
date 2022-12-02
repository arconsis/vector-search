package com.arconsis.recommendationcoreservice.tmdb.rest.api.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Genre(val id: Long, val name: String)