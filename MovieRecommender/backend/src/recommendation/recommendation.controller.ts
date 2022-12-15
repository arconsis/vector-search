import { Controller, Post, UploadedFile, UseInterceptors } from '@nestjs/common'
import { RecommendationService } from './recommendation.service'
import { RecommendedMoviesDto } from './recommendation.response.dto'
import { FileInterceptor } from '@nestjs/platform-express'

@Controller('recommendation')
export class RecommendationController {
  constructor(private readonly recommendationService: RecommendationService) {}

  @Post('image')
  @UseInterceptors(FileInterceptor('file'))
  async uploadImageFile(
    @UploadedFile() imageFile: Express.Multer.File
  ): Promise<RecommendedMoviesDto> {
    const recommendedMovies =
      await this.recommendationService.getRecommendations(imageFile)
    return { movies: recommendedMovies }
  }
}
