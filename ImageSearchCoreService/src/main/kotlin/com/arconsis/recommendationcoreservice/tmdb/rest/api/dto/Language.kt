package com.arconsis.recommendationcoreservice.tmdb.rest.api.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Language(@JsonProperty("iso_639_1") val languageCode: String, val name: String)
