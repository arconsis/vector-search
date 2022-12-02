package com.arconsis.recommendationcoreservice.dataimport

import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/import")
class ImportEndpoint(private val importService: ImportService) {

    @POST
    fun importProducts() {
        importService.importProducts()
    }
}