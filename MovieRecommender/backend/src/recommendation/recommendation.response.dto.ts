export class MovieResponseDto {
    movieId: string
    name: string
    certainty: number
    description: string
    imageUrl: string
}

export class RecommendationResponseDto {
    movies: MovieResponseDto[]
}
