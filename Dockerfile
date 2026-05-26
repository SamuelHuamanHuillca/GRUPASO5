

# 1. Fase de compilación: Usamos Maven con Java 21 para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. Fase de ejecución: Usamos una imagen ligera de Java 21 (Temurin) para correr la API
FROM eclipse-temurin:21-jre-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]