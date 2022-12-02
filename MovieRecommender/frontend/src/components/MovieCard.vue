<template>
  <div class="card">
    <div class="card-image">
      <figure class="image is-3by4">
        <img :src="movie.imageUrl" alt="Placeholder image" />
      </figure>
    </div>
    <div class="card-content">
      <div class="media">
        <div class="media-content">
          <p class="title is-4">{{ movie.name }}</p>
          <p class="subtitle is-6">Certainty: {{ movie.certainty }}</p>
        </div>
      </div>

      <div class="content">{{ movie.description }}</div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  props: {
    movie: Object,
  },
})
</script>

<style lang="scss" scoped></style>
