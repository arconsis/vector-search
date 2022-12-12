<template>
  <div>
    <h1 class="title is-1">Movie Recommender</h1>
    <img :src="uploadedImage" v-if="uploadedImage.length" alt="Placeholder image" id="uploaded-image">
    <ImageUpload @image-uploaded="getMoviesByImage" id="image-upload"/>
    <SimilarMovies :movies="similarMovies" v-if="(similarMovies.length > 0)" id="similar-movies"/>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import ImageUpload from '../components/ImageUpload.vue'
import SimilarMovies from '../components/SimilarMovies.vue'
import {getMoviesByReferenceImage} from '../rest/MoviesApi'

export default Vue.extend({
  name: 'MovieRecommender',
  components: {
    ImageUpload,
    SimilarMovies
  },
  data() {
    return {
      similarMovies: [] as Array<object>,
      uploadedImage: "" as string
    }
  },
  methods: {
    async getMoviesByImage(image: string) {
      this.uploadedImage = image
      this.similarMovies = []
      const recommendedMovies = await getMoviesByReferenceImage(image)
      this.similarMovies.push(
        {
          movieId: "1",
          name: "test movie 1",
          certainty: 1,
          description: "test description",
          image: image
        },
        {
          movieId: "2",
          name: "test movie 2",
          certainty: 2,
          description: "test description2",
          image: image
        },
        {
          movieId: "3",
          name: "test movie 3",
          certainty: 3,
          description: "test description3",
          image: image
        },
        {
          movieId: "4",
          name: "test movie 4",
          certainty: 4,
          description: "test description4",
          image: image
        },
        {
          movieId: "5",
          name: "test movie 5",
          certainty: 5,
          description: "test description5",
          image: image
        }
      )
    }
  }
});
</script>

<style scoped>
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
}

@media screen and (max-width: 900px) {
  #uploaded-image {
    width: 25%;
    height: 25%;
  }
}
</style>