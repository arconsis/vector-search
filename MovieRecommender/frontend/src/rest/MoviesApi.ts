import type { Movie } from "@/rest/MoviesDto";
import axios from "axios";

const axiosClient = axios.create({baseURL: "http://localhost:3000/recommendation"})

export async function getMoviesByReferenceImage(image: string): Promise<Movie[]> {
  try {
    const result = await axiosClient.get(`/image`, {data: {imageBase64: image}})
    return result.data as Movie[]
  } catch (error) {
    console.log("Fetch has failed:", error)
    return []
  }
}
