package com.arconsis.recommendationcoreservice.tmdb.rest.api.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Company(
    val name: String,
    val id: Long,
    @JsonProperty("logo_path") val logoPath: String?,
    @JsonProperty("origin_country") val originCountry: String,
)
