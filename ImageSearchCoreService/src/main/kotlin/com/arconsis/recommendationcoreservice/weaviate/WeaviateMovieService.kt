package com.arconsis.recommendationcoreservice.weaviate

import com.arconsis.recommendationcoreservice.data.content.MovieDetails
import com.arconsis.recommendationcoreservice.data.recommendation.MovieRecommendations
import com.arconsis.recommendationcoreservice.data.search.MovieRequest
import com.arconsis.recommendationcoreservice.dataimport.UpdateService
import com.arconsis.recommendationcoreservice.recommendation.MovieRecommendationService
import com.arconsis.recommendationcoreservice.weaviate.client.WeaviateService
import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviateMovieDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.`object`.WeaviatePosterDataHolder
import com.arconsis.recommendationcoreservice.weaviate.data.reference.WeaviateReferenceHolder
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeaviateMovieService(
    private val weaviateService: WeaviateService,
) : MovieRecommendationService,
    UpdateService {

    val movieObjects: MutableList<WeaviateMovieDataHolder> = mutableListOf()
    val posterObjects: MutableList<WeaviatePosterDataHolder> = mutableListOf()
    val references: MutableList<WeaviateReferenceHolder> = mutableListOf()

    override fun getSimilarMovies(request: MovieRequest): MovieRecommendations {
        TODO("Not yet implemented")
    }

    override fun getLatestMovieId(): Int {
        TODO("Not yet implemented")
    }

    override fun addMovieToBatch(movie: MovieDetails, batchSize: Int) {
        val movieObject = movie.toWeaviateMovieObject()

        movieObjects.add(movieObject)

        val posterObject = movie.toWeaviatePosterObject()

        if (posterObject != null) {
            val movieReference = movieObject.referenceTo(posterObject)
            val posterReference = posterObject.referenceTo(movieObject)

            posterObjects.add(posterObject)
            references.add(movieReference)
            references.add(posterReference)
        }

        if (movieObjects.size >= batchSize) {
            flush()
        }
    }

    override fun flush() {
        val objects = arrayOf(*movieObjects.toTypedArray(), *posterObjects.toTypedArray())

        weaviateService.batchUploadObjects(objects)
        weaviateService.batchUploadReferences(references.toTypedArray())

        movieObjects.clear()
        posterObjects.clear()
        references.clear()
    }

//    override fun getProduct(productId: String): ProductInformation {
//        TODO("Not yet implemented")
//    }
//
//    override fun getAllProducts(): List<ProductInformation> {
//        return weaviateGraphQLClient.getAllFurniture().toProductInformationList()
//    }
//
//    override fun addMovieToBatch(product: ProductInformation, base64EncodedImages: List<String>, batchSize: Int) {
//        // TODO remove objects if already existing
//
//        val furnitureObject = product.toWeaviateObject()
//        furnitureObjects.add(furnitureObject)
//
//        if (base64EncodedImages.isNotEmpty()) {
//            val furnitureImageObjects = base64EncodedImages.toWeaviateObjects()
//            this.furnitureImageObjects.addAll(furnitureImageObjects)
//            relationObjects.addAll(createWeaviateRelation(furnitureObject.id, furnitureImageObjects.map { it.id }))
//        }
//
//        if (furnitureObjects.size >= batchSize) {
//            flush()
//        }
//    }
//
//    fun ProductInformation.toWeaviateObject(): WeaviateObject<WeaviateFurnitureDto> =
//        WeaviateObject(className = FURNITURE_CLASS, id = UUID.randomUUID().toString(), properties = toWeaviateFurnitureDto())
//
//    fun ProductInformation.toWeaviateFurnitureDto(): WeaviateFurnitureDto = WeaviateFurnitureDto(
//        productId = productId,
//        modelName = modelName,
//        price = price,
//        description = description,
//        technicalDescription = technicalDescription,
//        highlights = highlights,
//        colors = colors,
//        sourceCountry = sourceCountry,
//        material = materials,
//        seatUpholstery = seatUpholstery,
//        backUpholstery = backUpholstery,
//        coverMaterial = coverMaterial,
//        category = category
//    )
//
//    private fun createWeaviateRelation(furnitureObjectId: String, furnitureImageObjectIds: List<String>): List<WeaviateRelationDto> {
//        return furnitureImageObjectIds.map {
//            listOf(
//                WeaviateRelationDto(
//                    hostUrl = weaviateBaseUrl,
//                    fromClass = FURNITURE_CLASS,
//                    fromObjectId = furnitureObjectId,
//                    fromField = FURNITURE_RELATION_FIELD,
//                    toClass = FURNITURE_IMAGE_CLASS,
//                    it
//                ), WeaviateRelationDto(
//                    hostUrl = weaviateBaseUrl,
//                    fromClass = FURNITURE_IMAGE_CLASS,
//                    fromObjectId = it,
//                    fromField = FURNITURE_IMAGE_RELATION_FIELD,
//                    toClass = FURNITURE_CLASS,
//                    furnitureObjectId
//                )
//            )
//        }.flatten()
//    }
//
//    fun List<String>.toWeaviateObjects(): List<WeaviateObject<WeaviateFurnitureImageDto>> = map { it.toWeaviateObject() }
//
//    fun String.toWeaviateObject(): WeaviateObject<WeaviateFurnitureImageDto> =
//        WeaviateObject(className = FURNITURE_IMAGE_CLASS, id = UUID.randomUUID().toString(), properties = toWeaviateFurnitureImageDto())
//
//    fun String.toWeaviateFurnitureImageDto(): WeaviateFurnitureImageDto = WeaviateFurnitureImageDto(image = this)
//
//    override fun getSimilarMovies(searchParameters: SearchByProductIdOptions): List<SearchResult> {
//        TODO("Not yet implemented")
//    }
//
//    override fun getSimilarProductsByImage(searchParameters: SearchByImageOptions): List<SearchResult> {
//        TODO("Not yet implemented")
//    }
}