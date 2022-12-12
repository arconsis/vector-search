package com.arconsis.recommendationcoreservice.weaviate.client

import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviateDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.reference.WeaviateReferenceHolder
import javax.enterprise.context.ApplicationScoped
import technology.semi.weaviate.client.WeaviateClient

@ApplicationScoped
class WeaviateService(private val weaviateClient: WeaviateClient) {

    fun batchUploadObjects(holders: Array<WeaviateDataHolder>) {
        if (holders.isEmpty()) return

        weaviateClient.batch().objectsBatcher().withObjects(*holders.toWeaviateObjects()).run()
    }

    fun batchUploadReferences(references: Array<WeaviateReferenceHolder>) {
        if (references.isEmpty()) return

        weaviateClient.batch().referencesBatcher().withReferences(*references.toBatchReferences()).run()
    }
}