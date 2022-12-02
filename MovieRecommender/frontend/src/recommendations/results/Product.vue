<script setup lang="ts">
import type {Product} from "@/recommendations/rest/ProductsDto";

const props = defineProps({
  product: Object as () => Product
})
</script>

<template>
  <div class="productContainer">
    <img class="productImage" :src="product.image" alt="image of a similar product">
    <p>Name: {{ product.name }}</p>
    <p>Kind: {{ product.kind }}</p>
    <p>Certainty: {{ product.certainty }}</p>
    <p>Description: {{ product.description }}</p>
  </div>
</template>

<style scoped>

.productImage {
  max-width: 100px;
}

.productContainer {
  padding: 12px;
}

</style>