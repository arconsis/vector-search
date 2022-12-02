<script setup lang="ts">
import {ref} from "vue";

const emit = defineEmits(["search"])

const productId = ref("")

function searchPressed() {
  emit("search", productId.value)
  productId.value = ""
}
</script>


<template>
  <h1>Search by product id</h1>
  <form @click.prevent>
    <input v-model="productId">

    <button @click="searchPressed">Submit search</button>
  </form>
</template>


<style scoped>

</style>