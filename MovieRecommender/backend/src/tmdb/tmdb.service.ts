import { Injectable } from '@nestjs/common'
import { TmdbApi } from './tmdb.api'
import { TmdbMovie } from './tmdb.movie.dto'

@Injectable()
export class TmdbService {
  constructor(private tmdbApi: TmdbApi) {}

  private async getMovieById(id: string): Promise<TmdbMovie> {
    const movie = await this.tmdbApi.getMovieFromTmdb(id)
    const image = 'https://image.tmdb.org/t/p/w500' + movie.poster_path
    return {
      movieId: id,
      name: movie.original_title,
      description: movie.overview,
      imageUrl: image,
    }
  }

  async getMovies(movies: string[]): Promise<TmdbMovie[]> {
    const providedMovies = await Promise.all(
      movies.map(async id => await this.getMovieById(id))
    )

    return providedMovies
  }
}
