<template>
  <div>
    <span v-for="i in movies.length">
      <b-icon
        v-if="i - 1 >= currentSlide && i - 1 < currentSlide + showSlides"
        icon="circle"
        size="is-small"
        type="is-success"
      ></b-icon>
      <b-icon
        v-else
        @click.native="changeCurrentSlide(i)"
        icon="circle-outline"
        size="is-small"
        type="is-success"
      ></b-icon>
    </span>
    <b-carousel-list
      v-model="currentSlide"
      :data="movies"
      :items-to-show="showSlides"
      class="movie-card"
      icon-size="is-medium"
      :repeat="true"
    >
      <template #item="list" type="is-success">
        <MovieCard :movie="list" />
      </template>
    </b-carousel-list>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import MovieCard from "../components/MovieCard.vue";

export default Vue.extend({
  components: {
    MovieCard,
  },
  props: {
    movies: Array,
  },
  data() {
    return {
      currentSlide: 0,
      showSlides: 1,
    };
  },
  mounted() {
    window.addEventListener("resize", this.onResize);
    this.onResize();
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.onResize);
  },
  methods: {
    onResize() {
      if (window.innerWidth < 800) this.showSlides = 1;
      else if (window.innerWidth < 1100) this.showSlides = 2;
      else if (window.innerWidth < 1500) this.showSlides = 3;
      else this.showSlides = 4;
    },
    changeCurrentSlide(i: number) {
      if (i < this.showSlides) this.currentSlide = i - 1;
      else this.currentSlide = i - this.showSlides;
    },
  },
});
</script>

<style scoped>
.movie-card {
  margin: 0 10% 30px 10%;
  max-width: 80%;
}
</style>
