package com.arconsis.recommendationcoreservice.recommendation.grpc

import io.grpc.stub.StreamObserver

fun <A, R> StreamObserver<R>.respond(request: A, body: A.() -> R) {
    val result = body(request)

    onNext(result)
    onCompleted()
}