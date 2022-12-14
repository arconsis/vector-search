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

  private getBase64(file: string): string {
    return Buffer.from(file, 'utf-8').toString('base64')
  }

  async getMoviesFromTmdb(id: string): Promise<TmdbRequestDto> {
    const tmdbApiKey = this.configService.get<string>('TMDB_API_KEY')
    const request = 'https://api.themoviedb.org/3/movie/' + id +
      '?api_key=' + tmdbApiKey +
      '&language=en-US'
    return this.tmdbGetRequest<TmdbRequestDto>(request)
  }

  async getImageFromTmdb(poster_path: string): Promise<string> {
    const request = 'https://image.tmdb.org/t/p/w500' + poster_path
    return this.getBase64(await this.tmdbGetRequest<string>(request))
  }
}
