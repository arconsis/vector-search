<script setup lang="ts">
import ResultSection from "@/recommendations/results/ResultSection.vue"
import SearchSection from "@/recommendations/search/SearchSection.vue"
import {ref} from "vue";
import type {Products} from "@/recommendations/rest/ProductsDto";
import {getProductsByReferenceId} from "@/recommendations/rest/ProductsApi";

const products = ref<Products>({similar: [], related: []})
let productIdCounter = 1

function generateMockProduct() {
  return {
    productId: `${productIdCounter++}`,
    name: `${Math.random() * 10}`,
    certainty: Math.random(),
    kind: "mock",
    image: "https://thumbs.dreamstime.com/z/business-woman-ok-hand-sign-27128198.jpg",
    description: "mock description"
  }
}

async function handleSearch(productId: string) {
  console.log(`searching for ${productId}`)
  products.value = await getProductsByReferenceId(productId)
}
</script>

<template>
  <h1>Product Search</h1>
  <div class="horizontal">
    <div class="vertical">
      <SearchSection @search="(productId) => handleSearch(productId)"/>
      <ResultSection :products="products"/>
    </div>
  </div>
</template>

<style scoped>
.vertical {
  display: flex;
  flex-direction: column;
}

.horizontal {
  display: flex;
  flex-direction: row;
}

.button {
  min-width: 100px;
  min-height: 50px;
  border: none;
  elevation: 1deg;
}
</style>