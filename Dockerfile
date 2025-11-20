# Imagem Java confiável no Docker Hub
FROM eclipse-temurin:17-jdk-jammy

# Diretório de trabalho
WORKDIR /app

# Copia o jar gerado para dentro do container
COPY target/workconnect-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar a API
ENTRYPOINT ["java", "-jar", "app.jar"]
