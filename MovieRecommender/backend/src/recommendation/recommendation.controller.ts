import {Controller, Get, Param} from "@nestjs/common";
import {RecommendationService} from "./recommendation.service";
import {RecommendationResponseDto} from "./recommendation.response.dto";

@Controller("/recommendation")
export class RecommendationController {
    constructor(private readonly recommendationService: RecommendationService) {
    }

    @Get(":productId")
    getRecommendations(@Param("id") id: string): RecommendationResponseDto {
        return this.recommendationService.getRecommendationsFor(id)
    }

}