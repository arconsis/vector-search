<template>
  <div class="upload-wrapper">
    <b-field class="file is-success" :class="{ 'has-name': !!file }">
      <b-upload v-model="file" class="file-label" accept="image/*">
        <span class="file-cta">
          <b-icon class="file-icon" icon="upload"></b-icon>
          <span class="file-label">Upload picture</span>
        </span>
        <span
          class="file-name"
          v-if="file && windowSizeNotPhone()"
          @change="emitImageString(file)"
        >
          {{ file.name }}
        </span>
      </b-upload>
    </b-field>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'ImageUpload',
  data() {
    return {
      file: null,
    }
  },
  watch: {
    file(newFile) {
      this.emitImage(newFile)
    },
  },
  methods: {
    emitImage(imageFile: File) {
      this.$emit('image-uploaded', imageFile)
    },
    windowSizeNotPhone() {
      return window.innerWidth > 800
    },
  },
})
</script>

<style scoped>
.upload-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
