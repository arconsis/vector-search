package com.arconsis.recommendationcoreservice.weaviate.data.reference

data class WeaviateReferenceHolder(
    private val fromClass: String,
    private val fromObjectId: String,
    private val fromField: String,
    private val toClass: String,
    private val toObjectId: String
) {
    val from: String
        get() = "weaviate://localhost/$fromClass/$fromObjectId/$fromField"

    val to: String
        get() = "weaviate://localhost/$toClass/$toObjectId"
}


