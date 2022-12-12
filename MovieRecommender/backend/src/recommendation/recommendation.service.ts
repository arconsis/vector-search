import { Injectable } from "@nestjs/common";
import { ConfigService } from "@nestjs/config";
import { RecommendationResponseDto } from "./recommendation.response.dto";

@Injectable()
export class RecommendationService {
    constructor(private configService: ConfigService) {}

    private async getMovies(image: string): Promise<RecommendationResponseDto> {
        //TODO add API call to backend for image
        const movieIds = ["436270", "505642", "76600", "829280", "438148"]

        //TODO add Api
        const tmdbApiKey = this.configService.get<string>('TMDB_API_KEY')

        return {
            movieId: "string",
            name: "string",
            certainty: 0.1,
            description: "string",
            image: "string",
        }
    }
    async getRecommendationsByImage(image: string): Promise<RecommendationResponseDto> {
        return await this.getMovies(image)
    }
}