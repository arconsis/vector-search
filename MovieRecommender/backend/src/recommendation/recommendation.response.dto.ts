export class RecommendedMovieDto {
  movieId: string
  name: string
  certainty: number
  description: string
  imageUrl: string
}

export class RecommendedMoviesDto {
  movies: RecommendedMovieDto[]
}
