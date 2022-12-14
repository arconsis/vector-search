import { Body, Controller, Get } from "@nestjs/common";
import { RecommendationService } from "./recommendation.service";
import { RecommendationResponseDto } from "./recommendation.response.dto";
import { RecommendationRequestDto } from "./recommendation.request.dto";

@Controller("recommendation")
export class RecommendationController {
    constructor(private readonly recommendationService: RecommendationService) {}

    @Get("image")
    async getRecommendations(@Body() image: RecommendationRequestDto): Promise<RecommendationResponseDto[]> {
        return await this.recommendationService.getRecommendationsByImage(image.imageBase64)
    }
}