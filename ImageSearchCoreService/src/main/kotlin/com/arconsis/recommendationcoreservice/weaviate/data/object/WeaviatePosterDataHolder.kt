package com.arconsis.recommendationcoreservice.weaviate.data.`object`

data class WeaviatePosterDataHolder(
    override val id: String,
    val image: String,
) : WeaviateDataHolder {
    override val className: String = "Poster"

    override val properties: Map<String, Any> = mapOf("image" to image)
}