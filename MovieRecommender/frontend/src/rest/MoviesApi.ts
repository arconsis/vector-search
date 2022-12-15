import type { Movies } from '@/rest/MoviesDto'
import axios from 'axios'

const axiosClient = axios.create({ baseURL: process.env.VUE_APP_BACKEND_URL })

export async function getMoviesByReferenceImageFile(
  image: File
): Promise<Movies> {
  try {
    const formData = new FormData()
    formData.append('file', image)
    const result = await axiosClient.post(`/image`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    })
    return result.data as Movies
  } catch (error) {
    console.log('Fetch has failed:', error)
    return { movies: [] }
  }
}
