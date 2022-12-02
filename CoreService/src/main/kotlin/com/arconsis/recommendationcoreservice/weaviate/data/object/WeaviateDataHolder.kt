package com.arconsis.recommendationcoreservice.weaviate.data.`object`

interface WeaviateDataHolder {
    val className: String
    val id: String
    val properties: Map<String, Any>
}