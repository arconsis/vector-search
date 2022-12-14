import { Injectable } from "@nestjs/common";
import { TmdbApi } from "./tmdb.api";
import { TmdbResponseDto } from "./tmdb.response.dto";

@Injectable()
export class TmdbService {
  constructor(private tmdbApi: TmdbApi) {}

  async getMovies(): Promise<TmdbResponseDto[]> {
    const movies = ["436270", "505642", "76600", "829280", "438148"]

    const proviededMovies = await Promise.all(movies.map(async id => {
      const movie = await this.tmdbApi.getMoviesFromTmdb(id)
      const image = 'https://image.tmdb.org/t/p/w500' + movie.poster_path
      return {
        movieId: id,
        name: movie.original_title,
        certainty: 0.1,
        description: movie.overview,
        imageUrl: image,
      }
    }))

    return proviededMovies
  }
}