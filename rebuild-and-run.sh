#!/bin/bash
set -e

echo "🚀 Enabling Docker BuildKit..."
export DOCKER_BUILDKIT=1
export COMPOSE_DOCKER_CLI_BUILD=1

echo "🧹 Cleaning up previous containers and volumes..."
docker compose down -v --remove-orphans

echo "📁 Creating shared Maven repository..."
mkdir -p ./maven-repo

echo "🔨 Building shared logging module..."
docker compose build shared-logging-builder
docker compose run --rm shared-logging-builder

echo "🚀 Building and starting application services..."
docker compose up --build -d

echo "✅ All services are up and running!"