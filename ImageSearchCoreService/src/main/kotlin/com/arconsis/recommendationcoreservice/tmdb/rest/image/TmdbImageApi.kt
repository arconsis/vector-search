package com.arconsis.recommendationcoreservice.tmdb.rest.image

import com.arconsis.recommendationcoreservice.common.ContentTypes
import java.io.File
import javax.ws.rs.DefaultValue
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestPath

@RegisterRestClient(configKey = "tmdb-image")
interface TmdbImageApi {

    @GET
    @Path("/{size}/{path}")
    @Produces(ContentTypes.IMAGE_WILDCARD)
    fun getImage(@RestPath path: String, @RestPath @DefaultValue(value = "original") size: String = "original"): File
}