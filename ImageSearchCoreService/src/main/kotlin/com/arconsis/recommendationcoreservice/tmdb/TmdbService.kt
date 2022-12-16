package com.arconsis.recommendationcoreservice.tmdb

import com.arconsis.recommendationcoreservice.data.content.MovieDetails
import com.arconsis.recommendationcoreservice.dataimport.DataFetchService
import com.arconsis.recommendationcoreservice.tmdb.rest.api.TmdbApi
import com.arconsis.recommendationcoreservice.tmdb.rest.file.TmdbFileApi
import com.arconsis.recommendationcoreservice.tmdb.rest.file.dto.MovieExportData
import com.arconsis.recommendationcoreservice.tmdb.rest.image.TmdbImageApi
import com.fasterxml.jackson.databind.ObjectMapper
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.zip.GZIPInputStream
import javax.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class TmdbService(
    @RestClient private val tmdbApi: TmdbApi,
    @RestClient private val tmdbFileApi: TmdbFileApi,
    @RestClient private val tmdbImageApi: TmdbImageApi,
    private val objectMapper: ObjectMapper
) : DataFetchService {

    override fun getAvailableMovieIds(): List<Long> {
        val zipStream = tmdbFileApi.getExportPack(currentDate)

        return GZIPInputStream(zipStream)
            .bufferedReader()
            .lines()
            .map { objectMapper.readValue(it, MovieExportData::class.java) }
            .map { it.id }
            .toList()
            .sorted()
    }

    override fun getMovie(movieId: Long): MovieDetails {
        val movie = tmdbApi.getMovieById(movieId)

        val poster: String? = if (movie.posterPath != null) {
            val posterFile = tmdbImageApi.getImage(path = movie.posterPath)
            Base64.getEncoder().encodeToString(posterFile.readBytes())
        } else {
            null
        }

        return movie.toInternal(poster)
    }

    companion object {
        private val dateFormatter = DateTimeFormatter.ofPattern("MM_DD_YYYY")
        private val currentDate: String
            get() = OffsetDateTime.now().format(dateFormatter)
    }
}