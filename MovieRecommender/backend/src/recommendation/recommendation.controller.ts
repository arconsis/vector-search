import {Body, Controller, Get, Param} from "@nestjs/common";
import {RecommendationService} from "./recommendation.service";
import {RecommendationResponseDto} from "./recommendation.response.dto";
import { MovieResponseDto } from "src/movie/movie.response.dto";

@Controller("recommendation")
export class RecommendationController {
    constructor(private readonly recommendationService: RecommendationService) {}

    @Get("image")
    async getRecommendations(@Body() image: {imageBase64: string}): Promise<MovieResponseDto> {
        return await this.recommendationService.getRecommendationsByImage(image.imageBase64)
    }
}