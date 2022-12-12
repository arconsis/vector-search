import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { RecommendationModule } from "./recommendation/recommendation.module";

@Module({
    imports: [ConfigModule.forRoot(), RecommendationModule],
    controllers: [],
    providers: [],
})
export class AppModule {}
