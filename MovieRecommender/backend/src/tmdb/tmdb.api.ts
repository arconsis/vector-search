import { HttpService } from "@nestjs/axios";
import { Injectable } from "@nestjs/common";
import { ConfigService } from "@nestjs/config";
import { AxiosError } from "axios";
import { catchError, firstValueFrom } from "rxjs";
import { TmdbRequestDto } from "./tmdb.request.dto";

@Injectable()
export class TmdbApi {
  constructor(
    private readonly httpService: HttpService,
    private readonly configService: ConfigService,
  ) {}

  private async tmdbGetRequest<T>(request: string): Promise<T> {
    const { data } = await firstValueFrom(
      this.httpService.get<T>(request).pipe(
        catchError((error: AxiosError) => {
          console.log(error.response.data);
          throw 'An error happened!';
        }),
      ),
    );
    return data
  }

  async getMoviesFromTmdb(id: string): Promise<TmdbRequestDto> {
    const tmdbApiKey = this.configService.get<string>('TMDB_API_KEY')
    const request = 'https://api.themoviedb.org/3/movie/' + id +
      '?api_key=' + tmdbApiKey +
      '&language=en-US'
    return this.tmdbGetRequest<TmdbRequestDto>(request)
  }
}
