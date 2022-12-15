import { NestFactory } from "@nestjs/core";
import { json } from "express";
import { AppModule } from "./app.module";
import { ConfigService } from "@nestjs/config";

async function bootstrap() {
  const app = await NestFactory.create(AppModule);

  const configService = app.get(ConfigService);
  app.enableCors({ origin: [configService.get("CORS_ORIGIN")] });
  app.use(json({ limit: "25mb" }));

  await app.listen(3000);
}

bootstrap();
