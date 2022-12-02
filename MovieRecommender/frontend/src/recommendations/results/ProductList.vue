<script setup lang="ts">
import type {Product as ProductType} from "@/recommendations/rest/ProductsDto";
import Product from "@/recommendations/results/Product.vue";

const props = defineProps({
  products: Object as () => ProductType[]
})
</script>

<template>
  <ul>
    <li v-for="product in products" :key="product.productId">
      <Product :product="product"/>
    </li>
  </ul>
</template>

<style scoped>

ul {
  list-style-type: none;
  display: flex;
  flex-direction: row;
}

</style>