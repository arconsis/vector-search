import { Module } from '@nestjs/common';
import { TmdbModule } from 'src/tmdb/tmdb.module';
import { RecommendationController } from "./recommendation.controller";
import { RecommendationService } from "./recommendation.service";

@Module({
    imports: [TmdbModule],
    controllers: [RecommendationController],
    providers: [RecommendationService],
})
export class RecommendationModule {}
