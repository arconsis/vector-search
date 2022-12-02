package com.arconsis.recommendationcoreservice.weaviate.client

import javax.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import technology.semi.weaviate.client.Config
import technology.semi.weaviate.client.WeaviateClient

@ApplicationScoped
class WeaviateClientProducer(
    @ConfigProperty(name = "weaviate.scheme") private val scheme: String,
    @ConfigProperty(name = "weaviate.host") private val host: String
) {

    @ApplicationScoped
    fun produceWeaviateClient(): WeaviateClient {
        val config = Config(scheme, host)

        return WeaviateClient(config)
    }
}