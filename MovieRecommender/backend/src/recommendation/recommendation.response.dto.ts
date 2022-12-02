import {ProductResponseDto} from "../product/product.response.dto";

export interface RecommendationResponseDto {
    similar: ProductResponseDto[]
    related: ProductResponseDto[]
}