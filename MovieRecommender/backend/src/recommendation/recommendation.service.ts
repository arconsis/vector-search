import {Injectable} from "@nestjs/common";
import { MovieResponseDto } from "src/movie/movie.response.dto";

@Injectable()
export class RecommendationService {

    private async getMovies(image: string): Promise<MovieResponseDto> {
        //TODO add API call to backend for image
        const movieIds = ["436270", "505642", "76600", "829280", "438148"]
        // const 


        return {
            movieId: "string",
            name: "string",
            certainty: 0.1,
            description: "string",
            image: "string",
        }
    }

    async getRecommendationsByImage(image: string): Promise<MovieResponseDto> {
        return await this.getMovies(image)
    }

    // getRecommendationsById(id: string): RecommendationResponseDto {
    //     return {
    //         similar: [
    //             {
    //                 productId: "1",
    //                 certainty: 0.5,
    //                 kind: "chair",
    //                 name: "mock product",
    //                 image: "http://localhost:7122/productImage/VAXS90RB_HB_EB_FREI_1.jpg",
    //                 description: "mocked description for a wonderfully comfortable chair",
    //             },
    //             {
    //                 productId: "1",
    //                 certainty: 0.5,
    //                 kind: "chair",
    //                 name: "mock product",
    //                 image: "http://localhost:7122/productImage/VAXS90RB_HB_EB_FREI_2.jpg",
    //                 description: "mocked description for a wonderfully comfortable chair",
    //             }
    //         ], related: [
    //             {
    //                 productId: "2",
    //                 certainty: 0.5,
    //                 kind: "chair",
    //                 name: "mock product",
    //                 image: "http://localhost:7122/productImage/TO4E79RB_HB_EB_FREI_1.jpg",
    //                 description: "mocked description for a wonderfully comfortable chair",
    //             }
    //         ]
    //     }
    // }
}