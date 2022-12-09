import type {Movies, Movie} from "@/rest/MoviesDto";
import axios from "axios";

const axiosClient = axios.create({baseURL: "http://localhost:3000/recommendation"})

export async function getMoviesByReferenceId(moviesId: string): Promise<Movies> {
  try {
    const result = await axiosClient.get(`/${moviesId}`)
    return result.data as Movies
  } catch (error) {
    return {related: [], similar: []}
  }
}

export async function getMoviesByReferenceImage(image: string): Promise<Movie[]> {
  try {
    const result = await axiosClient.get(`/image`, {data: image})
    return result.data as Movie[]
  } catch (error) {
    return []
  }
}