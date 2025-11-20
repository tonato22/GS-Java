# WorkConnect

Plataforma web de comunidade colaborativa de aprendizagem.

## Tecnologias

- Spring Boot 3
- Spring MVC + Thymeleaf
- Spring Security
- Spring Data JPA (PostgreSQL)
- Bean Validation
- Caching com Caffeine
- Internacionalização (pt-BR e en-US)
- RabbitMQ (mensageria)
- Spring AI (OpenAI)
- Flyway (migrações)
- Deploy pronto para nuvem

## Como rodar

1. Criar banco PostgreSQL:

   ```sql
   CREATE DATABASE workconnect;
   ```

2. Ajustar `spring.datasource.username` e `spring.datasource.password` em `src/main/resources/application.properties`.

3. Subir RabbitMQ local (porta 5672) ou via Docker.

4. Definir a variável de ambiente `OPENAI_API_KEY` com sua chave da OpenAI.

5. Rodar o projeto:

   ```bash
   mvn spring-boot:run
   ```

6. Acessar:

   - `http://localhost:8080/` (Home)
   - `http://localhost:8080/register` (Criar conta)
   - `http://localhost:8080/login` (Login)
