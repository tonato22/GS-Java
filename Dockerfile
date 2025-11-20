# Imagem base do Java (leve e ideal para o Render)
FROM openjdk:17-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o jar gerado para dentro do container
COPY target/workconnect-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando que inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
