<template>
  <div class="card" @mouseover="showContent = true" @mouseout="showContent = false">
    <div class="card-image">
      <figure class="image is-3by4">
        <img :src="movie.imageUrl" alt="Placeholder image" />
      </figure>
    </div>
    <header class="card-header">
      <div class="title-wrapper">
        <span>
          <p class="title is-4">{{ movie.name }}</p>
          <p class="subtitle is-6">Certainty: {{ movie.certainty }}</p>
        </span>
        <span class="icon-wrapper">
          <b-icon
            v-if="showContent"
            icon="chevron-down"
            size="is-medium"
          ></b-icon>
          <b-icon
            v-else
            icon="chevron-up"
            size="is-medium"
          ></b-icon>
        </span>
      </div>
    </header>
    <transition name="dropdown">
      <div class="card-content" v-if="showContent">
        <div class="content">{{ movie.description }}</div>
      </div>
    </transition>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  props: {
    movie: Object,
  },
  data() {
    return {
      showContent: false,
    }
  },
})
</script>

<style scoped>
.title-wrapper {
  margin: .6rem auto .1rem auto;
}

.dropdown-enter-active {
  transition: all 1s;
}

.dropdown-leave-active {
  transition: all .5s;
}

.dropdown-enter, .dropdown-leave-to {
  transform: translateY(-1.5rem);
  opacity: 0;
}
</style>
