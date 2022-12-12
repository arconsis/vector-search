package com.arconsis.recommendationcoreservice.tmdb.rest.api.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Country(@JsonProperty("iso_3166_1") val countryCode: String, val name: String)
