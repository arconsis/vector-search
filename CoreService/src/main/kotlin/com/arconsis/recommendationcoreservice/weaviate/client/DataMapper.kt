package com.arconsis.recommendationcoreservice.weaviate.client

import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviateDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.reference.WeaviateReferenceHolder
import technology.semi.weaviate.client.v1.batch.model.BatchReference
import technology.semi.weaviate.client.v1.data.model.WeaviateObject

fun Array<WeaviateDataHolder>.toWeaviateObjects(): Array<WeaviateObject> = map { it.toWeaviateObject() }.toTypedArray()

fun WeaviateDataHolder.toWeaviateObject(): WeaviateObject = WeaviateObject.builder().apply {
    id(id)
    className(className)
    properties(properties)
}.build()

fun Array<WeaviateReferenceHolder>.toBatchReferences(): Array<BatchReference> = map { it.toBatchReference() }.toTypedArray()

fun WeaviateReferenceHolder.toBatchReference(): BatchReference = BatchReference.builder().apply {
    from(from)
    to(to)
}.build()