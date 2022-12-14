import type { Movies } from "@/rest/MoviesDto";
import axios from "axios";

const axiosClient = axios.create({baseURL: "http://localhost:3000/recommendation"})

export async function getMoviesByReferenceImageFile(image: File): Promise<Movies> {
  try {
    const formData = new FormData()
    formData.append('file', image)
    const result = await axiosClient.post(`/image`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    })
    return result.data as Movies
  } catch (error) {
    console.log("Fetch has failed:", error)
    return { movies: [] }
  }
}
