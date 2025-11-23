
# 🌐 WorkConnect – Plataforma Colaborativa de Aprendizagem  
## Deploy em Produção + IA + CRUD Completo + Autenticação + RabbitMQ

---

## 🚀 **📌 Link do Deploy (API + Interface Web)**
👉 **(https://workconnect-api-9o5h.onrender.com)**  

A aplicação está disponível 24/7 com:

- Autenticação  
- Feed de dicas  
- Criar, editar e visualizar dicas  
- Integração com IA  
- RabbitMQ  
- Banco de dados PostgreSQL

---

## 🔐 **Credenciais de Acesso (demo)**

**Usuário de Teste:**

- **Email:** gustavotonatosp@gmail.com  
- **Senha:** `1234`  

*(Use para navegar no sistema sem criar conta.)*

---

# 📘 **Sobre o Projeto**

A **WorkConnect** é uma plataforma colaborativa onde usuários compartilham:

- dicas profissionais  
- conhecimentos  
- boas práticas  
- recomendações de cursos  
- oportunidades de carreira  

Ela simula uma **comunidade de aprendizagem moderna**, alinhada ao *futuro do trabalho*.

---

## 🎯 **Principais Funcionalidades**

### ✔ Autenticação + Perfis  
- Login e registro  
- Autorização por Spring Security  
- Cada usuário possui nome, bio, skills e email

---

### ✔ CRUD Completo de Dicas  
- Criar nova dica  
- Listar todas as dicas com paginação  
- Visualizar dica específica  
- Editar  
- Excluir  

Cada dica tem:

- título  
- conteúdo  
- categoria  
- autor  
- data/hora  

---

### ✔ IA integrada (OpenAI GPT-4o-mini)  
Ajuda o usuário a escrever melhor:

- **Gerar título automático**  
- **Gerar resumo do conteúdo**  

Implementado via endpoint `/v1/responses`.

---

### ✔ RabbitMQ + Mensageria  
Quando uma dica é criada, uma mensagem é enviada para a fila:  

```
tip.created
```

Futuras integrações possíveis:

- analytics  
- dashboards  
- notificações  

---

### ✔ Cache + Paginação  
Feed rápido e otimizado usando:

- `@Cacheable`  
- `@CacheEvict`  

---

### ✔ Interface Web (Thymeleaf)  
Frontend estilizado com:

- formulários responsivos  
- navegação  
- feed de dicas  
- pages clean e organizadas  

---

# 🧠 **Arquitetura da Solução**

```
WorkConnect
├── Spring Boot 3
├── PostgreSQL (Render or Supabase)
├── RabbitMQ (CloudAMQP)
├── OpenAI API (IA)
├── Thymeleaf (Frontend)
├── Spring Security (Login/Auth)
└── Spring Cache (Otimização)
```

---

# 🔗 **Endpoints da API**

### **Autenticação**
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/auth/login` | Login do usuário |
| POST | `/auth/register` | Registro de novo usuário |

---

### **Dicas**
| Método | Rota | Descrição |
|--------|-------|-----------|
| GET | `/tips` | Lista paginada de dicas |
| POST | `/tips/new` | Cria uma nova dica |
| GET | `/tips/{id}` | Detalhe da dica |
| POST | `/tips/edit/{id}` | Edita uma dica |
| GET | `/tips/delete/{id}` | Remove uma dica |

---

### **IA**
| Método | Rota | Função |
|--------|-------|---------|
| POST | `/ai/title` | Gera título baseado no conteúdo |
| POST | `/ai/summary` | Gera resumo automático |

---

# 🐇 **RabbitMQ**

**Exchange:**  
```
workconnect.exchange
```

**Queue:**  
```
tip.created.queue
```

**Mensagens enviadas no create:**  
```json
{
  "id": 12,
  "title": "Como começar em Java",
  "author": "Diogo",
  "created_at": "2025-11-20T22:00:00"
}
```

---

# 🛠 **Como rodar localmente**

### 1. Clonar o projeto
```bash
git clone https://github.com/SEU_USUARIO/workconnect.git
cd workconnect
```

---

### 2. Configurar as variáveis (application.properties)

```properties
server.port=8080

spring.datasource.url=jdbc:postgresql://<HOST>:5432/<DB>
spring.datasource.username=<USER>
spring.datasource.password=<PASS>

openai.api.key=sk-xxxx
spring.rabbitmq.host=<HOST>
spring.rabbitmq.username=<USER>
spring.rabbitmq.password=<PASS>
```

---

### 3. Rodar a aplicação
```bash
mvn spring-boot:run
```

---

# 🧪 **Testar IA via Postman**

### Gerar título:
POST `https://workconnect-cloud.app/ai/title`

```json
{
  "content": "Como melhorar suas habilidades de Java"
}
```

### Gerar resumo:
POST `https://workconnect-cloud.app/ai/summary`

```json
{
  "content": "Texto completo da dica..."
}
```

---

# 📚 **ODS atendidos**

### 🎓 **ODS 4 – Educação de Qualidade**
- democratiza acesso a conhecimento  
- promove aprendizagem contínua  

### 🤝 **ODS 10 – Redução das Desigualdades**
- qualquer pessoa pode aprender e ensinar  
- reduz barreira econômica no acesso a capacitação  

---

# 👥 **Integrantes**
- **Gustavo Tonato** - RM555393
- **Diogo Weyne** – RM558380
- **João Victor de souza** - RM555290  


---

# 📹 **Vídeo Demonstrativo**
👉 **https://www.youtube.com/watch?v=Azbd4OktRAM**  


