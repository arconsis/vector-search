package com.arconsis.recommendationcoreservice.recommendation.grpc

import com.arconsis.recommendationcoreservice.MovieRecommendations
import com.arconsis.recommendationcoreservice.MovieRequest
import com.arconsis.recommendationcoreservice.RecommendationGRPCServiceGrpc.RecommendationGRPCServiceImplBase
import com.arconsis.recommendationcoreservice.recommendation.RecommendationService
import com.arconsis.recommendationcoreservice.recommendation.toGrpc
import com.arconsis.recommendationcoreservice.recommendation.toInternal
import io.grpc.stub.StreamObserver
import io.quarkus.grpc.GrpcService

@GrpcService
class RecommendationGRPCEndpoint(private val recommendationService: RecommendationService) : RecommendationGRPCServiceImplBase() {

    override fun getMovieRecommendation(request: MovieRequest, responseObserver: StreamObserver<MovieRecommendations>) = responseObserver.respond(request) {
        recommendationService.recommendationsForRequest(request.toInternal()).toGrpc()
    }
}