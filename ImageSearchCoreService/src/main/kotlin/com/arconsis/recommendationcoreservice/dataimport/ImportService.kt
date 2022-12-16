package com.arconsis.recommendationcoreservice.dataimport

import java.util.logging.Logger
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ImportService(private val dataFetchService: DataFetchService, private val updateService: UpdateService, private val logger: Logger) {

    private var processing: Boolean = false

    fun importProducts() {
        if (processing) {
            return
        }
        processing = true

        processing = false
        TODO("not implemented yet")
    }
}