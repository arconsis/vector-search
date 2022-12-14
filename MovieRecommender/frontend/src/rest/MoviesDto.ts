export interface Movies {
  movies: Movie[]
}

export interface Movie {
  movieId: string
  name: string
  certainty: number
  description: string
  imageUrl: string
}