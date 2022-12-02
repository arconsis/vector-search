<template>
  <div class="recommender-wrapper">
    <h1 class="title is-1">Movie Recommender</h1>
    <h1 class="subtitle is-4">
      Get movie recommendations based on the movie poster you upload
    </h1>
    <img
      :src="uploadedImage"
      v-if="uploadedImage.length"
      alt="Placeholder image"
      id="uploaded-image"
    />
    <ImageUpload @image-uploaded="getMoviesByImage" id="image-upload" />
    <SimilarMovies
      :movies="similarMovies.movies"
      v-if="similarMovies.movies.length > 0"
      id="similar-movies"
    />
    <CopyrightTmbd class="copyright-tmdb" />
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import ImageUpload from '../components/ImageUpload.vue'
import SimilarMovies from '../components/SimilarMovies.vue'
import CopyrightTmbd from '../components/CopyrightTmbd.vue'
import { getMoviesByReferenceImageFile } from '../rest/MoviesApi'
import { Movies } from '../rest/MoviesDto'

export default Vue.extend({
  name: 'MovieRecommender',
  components: {
    ImageUpload,
    SimilarMovies,
    CopyrightTmbd,
  },
  data() {
    return {
      similarMovies: { movies: [] } as Movies,
      uploadedImage: '' as string,
    }
  },
  methods: {
    async getMoviesByImage(image: File) {
      this.uploadedImage = await this.getFileString(image)
      this.similarMovies = { movies: [] }

      const recommendedMovies = await getMoviesByReferenceImageFile(image)
      recommendedMovies.movies.forEach(movie =>
        this.similarMovies.movies.push(movie)
      )
    },
    getFileString(image: File): Promise<string> {
      return new Promise((resolve, reject) => {
        const reader = new FileReader()
        reader.readAsDataURL(image)
        reader.onload = () =>
          resolve(
            typeof reader.result === 'string' ? reader.result?.toString() : ''
          )
        reader.onerror = () => reject('')
      })
    },
  },
})
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
