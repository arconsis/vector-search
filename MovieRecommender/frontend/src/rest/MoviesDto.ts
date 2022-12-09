export interface Movies {
  similar: Movie[]
  related: Movie[]
}

export interface Movie {
  movieId: string
  name: string
  certainty: number
  description: string
  image: string
}