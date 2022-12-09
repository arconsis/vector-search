import {NestFactory} from '@nestjs/core';
import {json} from 'express';
import {AppModule} from './app.module';

async function bootstrap() {
    const app = await (await NestFactory.create(AppModule, {cors: {origin: ["http://localhost:5173"]}}));
    app.use(json({limit: '25mb'}))
    await app.listen(3000);
}

bootstrap();
