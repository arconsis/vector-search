import { Injectable } from "@nestjs/common";
import { TmdbService } from "src/tmdb/tmdb.service";
import { RecommendationResponseDto } from "./recommendation.response.dto";

@Injectable()
export class RecommendationService {
    constructor(
        private readonly tmdbService: TmdbService
    ) {}

    async getRecommendationsByImage(image: string): Promise<RecommendationResponseDto[]> {
        //TODO add API call to backend for image 
        return await this.tmdbService.getMovies()
    }
}