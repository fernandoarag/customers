# Build stage
# Start with maven:3.8.7-amazoncorretto-21 base image
FROM maven:3.9.9-amazoncorretto-21 AS build

LABEL maintainer="Fernando Aragão <fernandoarag@gmail.com>"
ARG JAR_NAME="customermanagement-1.0.0.jar"

# copy pom.xml from context into image
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package


#Run stage
FROM amazoncorretto:21

# Copia o JAR gerado pelo Gradle/Maven para dentro do container
COPY --from=build /app/target/${JAR_NAME} /app/${JAR_NAME}

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/customermanagement-1.0.0.jar"]


