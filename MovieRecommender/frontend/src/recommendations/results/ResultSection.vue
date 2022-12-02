<script setup lang="ts">
import type {Products} from "@/recommendations/rest/ProductsDto";
import ProductList from "@/recommendations/results/ProductList.vue";

const props = defineProps({
  products: Object as () => Products
})

</script>

<template>
  <h2>Similar Products</h2>
  <ProductList :products="products.similar"/>
  <h2>Related Products</h2>
  <ProductList :products="products.related"/>
</template>

<style scoped>
h2 {
  font-weight: bold;
}
</style>