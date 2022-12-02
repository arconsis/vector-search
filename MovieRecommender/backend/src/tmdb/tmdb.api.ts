import { HttpService } from '@nestjs/axios'
import { Injectable } from '@nestjs/common'
import { ConfigService } from '@nestjs/config'
import { AxiosError } from 'axios'
import { catchError, firstValueFrom } from 'rxjs'
import { TmdbApiResponseDto } from './tmdb.api.response.dto'

@Injectable()
export class TmdbApi {
  constructor(
    private readonly httpService: HttpService,
    private readonly configService: ConfigService
  ) {}

  private async tmdbGetRequest<T>(request: string): Promise<T> {
    const { data } = await firstValueFrom(
      this.httpService.get<T>(request).pipe(
        catchError((error: AxiosError) => {
          console.log(error.response.data)
          throw 'An error happened!'
        })
      )
    )
    return data
  }

  async getMovieFromTmdb(id: string): Promise<TmdbApiResponseDto> {
    const tmdbApiKey = this.configService.get<string>('TMDB_API_KEY')
    const request = `https://api.themoviedb.org/3/movie/${id}?api_key=${tmdbApiKey}&language=en-US`
    return this.tmdbGetRequest<TmdbApiResponseDto>(request)
  }
}
