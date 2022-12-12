import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { RecommendationController } from "./recommendation.controller";
import { RecommendationService } from "./recommendation.service";

@Module({
    imports: [ConfigModule],
    controllers: [RecommendationController],
    providers: [RecommendationService],
})
export class RecommendationModule {
}
