<template>
    <div class="upload-wrapper">
        <b-field class="file is-success" :class="{'has-name': !!file}">
            <b-upload v-model="file" class="file-label" accept="image/*">
                <span class="file-cta">
                    <b-icon class="file-icon" icon="upload"></b-icon>
                    <span class="file-label">Upload picture</span>
                </span>
                <span class="file-name" v-if="file" @change="emitImageString(file)">
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
        file: null
    }
  },
  watch: {
    file(newFile, oldFile) {
        this.emitImageString(newFile)
    }
  },
  methods: {
    emitImageString(imageFile: File) {
        const reader = new FileReader()
        reader.readAsDataURL(imageFile)
        reader.onload = () => {
            this.$emit("image-uploaded", reader.result)
        }
        reader.onerror = (error) => {
            console.log('Error: ', error)
        }
    }
  }
});
</script>

<style scoped>
.upload-wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>