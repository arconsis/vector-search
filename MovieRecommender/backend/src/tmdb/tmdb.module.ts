import { HttpModule } from '@nestjs/axios'
import { Module } from '@nestjs/common'
import { ConfigModule } from '@nestjs/config'
import { TmdbApi } from './tmdb.api'
import { TmdbService } from './tmdb.service'

@Module({
  imports: [ConfigModule, HttpModule],
  providers: [TmdbService, TmdbApi],
  exports: [TmdbService],
})
export class TmdbModule {}
