<template>
  <div>
    <b-carousel-list v-model="currentSlide" :data="movies" :items-to-show="showSlides" class="movie-card" icon-size="is-medium" repeat="true">
        <template #item="list">
          <MovieCard :movie="list" />
        </template>
    </b-carousel-list>
  </div>
</template>

<script lang="ts">
  import Vue from 'vue'
  import MovieCard from '../components/MovieCard.vue'

  export default Vue.extend({
    components: {
      MovieCard
    },
    props: {
      movies: Array
    },
    data() {
      return {
        currentSlide: 0,
        showSlides: 2
      }
    },
    mounted() {
      window.addEventListener("resize", this.onResize)
      this.onResize()
    },
    beforeDestroy() {
      window.removeEventListener("resize", this.onResize)
    },
    methods: {
      onResize() {
        if(window.innerWidth < 800) this.showSlides = 1
        else if(window.innerWidth < 1100) this.showSlides = 2
        else if(window.innerWidth < 1500) this.showSlides = 3
        else this.showSlides = 4
      }
    }
  })
</script>

<style scoped>
.movie-card {
  margin-left: 10%;
  margin-right: 10%;
  margin-bottom: 30px;
  max-width: 80%;
}
</style>
