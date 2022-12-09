import {Module} from '@nestjs/common';
import {RecommendationModule} from "./recommendation/recommendation.module";

@Module({
    imports: [RecommendationModule],
    controllers: [],
    providers: [],
})
export class AppModule {
}
