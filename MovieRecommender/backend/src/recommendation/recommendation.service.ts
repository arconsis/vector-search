import { Injectable } from '@nestjs/common'
import { TmdbService } from 'src/tmdb/tmdb.service'
import { RecommendedMovieDto } from './recommendation.response.dto'

@Injectable()
export class RecommendationService {
  constructor(private readonly tmdbService: TmdbService) {}

  async getRecommendations(
    imageFile: Express.Multer.File
  ): Promise<RecommendedMovieDto[]> {
    // TODO move image Converter to own module for vector call
    // const imageAsBase64 = Buffer.from(imageFile.buffer).toString('base64')
    // TODO add API call to backend for image
    const movies = ['436270', '505642', '76600', '829280', '438148']

    const receivedMovies = await this.tmdbService.getMovies(movies)

    return receivedMovies.map(movie => {
      return {
        movieId: movie.movieId,
        name: movie.name,
        certainty: 0.1,
        description: movie.description,
        imageUrl: movie.imageUrl,
      }
    })
  }
}
