package com.arconsis.recommendationcoreservice.tmdb.rest.file

import java.io.InputStream
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestPath

@RegisterRestClient(configKey = "tmdb-file")
interface TmdbFileApi {

    /**
     * @param date has to have format like MM_DD_YYYY
     */
    @GET
    @Path("/exports/movie_ids_{date}.json.gz")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    fun getExportPack(@RestPath("date") date: String): InputStream
}