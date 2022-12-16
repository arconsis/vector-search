package com.arconsis.recommendationcoreservice.common

fun <K, V> Map<K, V?>.mapNotNullValues(): Map<K, V> = mapNotNull { (key, value) -> value?.let { key to value } }.toMap()

fun <K, V> mapOfNotNullValues(vararg pairs: Pair<K, V?>): Map<K, V> = pairs.toMap().mapNotNullValues()