<template>
  <div class="recommender-wrapper">
    <h1 class="title is-1">Movie Recommender</h1>
    <h1 class="subtitle is-4">Get movie recommendations based on the movie poster you upload</h1>
    <img :src="uploadedImage" v-if="uploadedImage.length" alt="Placeholder image" id="uploaded-image" />
    <ImageUpload @image-uploaded="getMoviesByImage" id="image-upload"/>
    <SimilarMovies :movies="similarMovies" v-if="(similarMovies.length > 0)" id="similar-movies"/>
    <CopyrightTmbd class="copyright-tmdb"/>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import ImageUpload from '../components/ImageUpload.vue'
import SimilarMovies from '../components/SimilarMovies.vue'
import CopyrightTmbd from '../components/CopyrightTmbd.vue';
import {getMoviesByReferenceImage} from '../rest/MoviesApi'
import { Movie } from '../rest/MoviesDto';

export default Vue.extend({
  name: 'MovieRecommender',
  components: {
    ImageUpload,
    SimilarMovies,
    CopyrightTmbd
},
  data() {
    return {
      similarMovies: [] as Array<Movie>,
      uploadedImage: "" as string
    }
  },
  methods: {
    async getMoviesByImage(image: string) {
      this.uploadedImage = image
      this.similarMovies = []

      const recommendedMovies = await getMoviesByReferenceImage(image)
      recommendedMovies.forEach(movie => this.similarMovies.push(movie))
    }
  }
});
</script>

<style scoped>
.recommender-wrapper {
  display: flex;
  flex-direction: column;
}

#image-upload {
  display: flex;
  justify-content: center;
}

#similar-movies {
  margin-top: 1rem;
}

#uploaded-image {
  width: 15%;
  height: 15%;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 10px;
  border-radius: 5px;
}

@media screen and (max-width: 900px) {
  #uploaded-image {
    width: 25%;
    height: 25%;
  }
}

.copyright-tmdb {
  margin-top: 20px;
  margin-bottom: 10px;
}
</style>