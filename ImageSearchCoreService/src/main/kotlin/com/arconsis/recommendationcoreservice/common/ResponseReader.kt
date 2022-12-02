package com.arconsis.recommendationcoreservice.common

import javax.ws.rs.core.Response
import org.jboss.logging.Logger

object ResponseReader {

    val logger: Logger = Logger.getLogger(ResponseReader::class.java.name)

    inline fun <reified T> Response.readEntityOrNull(): T? {
        return if (status in 200..299) {
            readEntity(T::class.java)
        } else {
            logger.debug("${T::class.java.name} call returned status code $status")
            null
        }
    }

}
