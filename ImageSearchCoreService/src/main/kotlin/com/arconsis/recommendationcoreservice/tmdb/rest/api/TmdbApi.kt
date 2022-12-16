package com.arconsis.recommendationcoreservice.tmdb.rest.api

import com.arconsis.recommendationcoreservice.common.Headers
import com.arconsis.recommendationcoreservice.tmdb.rest.api.dto.MovieDetails
import javax.ws.rs.GET
import javax.ws.rs.Path
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestPath

@RegisterRestClient(configKey = "tmdb-api")
@ClientHeaderParam(name = Headers.AUTHORIZATION, value = ["tmdb.apiKey"])
interface TmdbApi {

    @GET
    @Path("/movie/latest")
    fun getLatestMovie(): MovieDetails

    @GET
    @Path("/movie/{movie_id}")
    fun getMovieById(@RestPath("movie_id") movieId: Long): MovieDetails
}