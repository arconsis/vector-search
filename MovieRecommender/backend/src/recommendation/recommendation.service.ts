import {Injectable} from "@nestjs/common";
import {RecommendationResponseDto} from "./recommendation.response.dto";

@Injectable()
export class RecommendationService {

    getRecommendationsFor(id: string): RecommendationResponseDto {
        return {
            similar: [
                {
                    productId: "1",
                    certainty: 0.5,
                    kind: "chair",
                    name: "mock product",
                    image: "http://localhost:7122/productImage/VAXS90RB_HB_EB_FREI_1.jpg",
                    description: "mocked description for a wonderfully comfortable chair",
                },
                {
                    productId: "1",
                    certainty: 0.5,
                    kind: "chair",
                    name: "mock product",
                    image: "http://localhost:7122/productImage/VAXS90RB_HB_EB_FREI_2.jpg",
                    description: "mocked description for a wonderfully comfortable chair",
                }
            ], related: [
                {
                    productId: "2",
                    certainty: 0.5,
                    kind: "chair",
                    name: "mock product",
                    image: "http://localhost:7122/productImage/TO4E79RB_HB_EB_FREI_1.jpg",
                    description: "mocked description for a wonderfully comfortable chair",
                }
            ]
        }
    }
}