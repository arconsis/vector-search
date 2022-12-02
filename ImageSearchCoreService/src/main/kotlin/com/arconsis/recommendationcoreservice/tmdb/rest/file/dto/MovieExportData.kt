package com.arconsis.recommendationcoreservice.tmdb.rest.file.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieExportData(
    val adult: Boolean,
    val id: Long,
    @JsonProperty("original_title")
    val originalTitle: String,
    val popularity: Double,
    val video: Boolean,
)