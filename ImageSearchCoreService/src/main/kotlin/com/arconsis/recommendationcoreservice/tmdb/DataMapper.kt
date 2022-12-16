package com.arconsis.recommendationcoreservice.tmdb

import com.arconsis.recommendationcoreservice.tmdb.rest.api.dto.MovieDetails

fun MovieDetails.toInternal(poster: String?) = com.arconsis.recommendationcoreservice.data.content.MovieDetails(
    adult = adult,
    collection = belongsToCollection?.name,
    budget = budget,
    genres = genres.map { it.name },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    poster = poster,
    productionCompanies = productionCompanies.map { it.name },
    productionCountries = productionCountries.map { it.name },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.name },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)