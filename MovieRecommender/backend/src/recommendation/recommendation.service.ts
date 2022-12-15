import { Injectable } from "@nestjs/common";
import { TmdbService } from "src/tmdb/tmdb.service";
import { RecommendationResponseDto } from "./recommendation.response.dto";

@Injectable()
export class RecommendationService {
  constructor(private readonly tmdbService: TmdbService) {}

  async getRecommendations(
    imageFile: Express.Multer.File
  ): Promise<RecommendationResponseDto> {
    const movieResult = { movies: [] };
    // TODO move image Converter to own module for vector call
    // const imageAsBase64 = Buffer.from(imageFile.buffer).toString('base64')
    // TODO add API call to backend for image
    const movies = ["436270", "505642", "76600", "829280", "438148"];

    (await this.tmdbService.getMovies(movies)).forEach((movie) =>
      movieResult.movies.push({
        movieId: movie.movieId,
        name: movie.name,
        certainty: 0.1,
        description: movie.description,
        imageUrl: movie.imageUrl,
      })
    );

    return movieResult;
  }
}
