# Usa uma imagem do OpenJDK 21 como base
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho dentro do container
# WORKDIR /app
RUN mkdir /app

# Copia o JAR gerado pelo Gradle/Maven para dentro do container
COPY target/*.jar myapp.jar

RUN mkdir /h2-data
COPY h2-data/ /h2-data/

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

CMD java -jar myapp.jar --spring.config.additional-location=file:/src/main/resources/application.yaml