# 🎓 Sistema de Gestão Acadêmica Inteligente

Este projeto é uma API REST para gerenciar alunos e matrículas. Ele integra processamento de linguagem natural (LLM) para facilitar a busca e interação com dados acadêmicos.

## 🚀 Tecnologias Utilizadas

*   **Java 21**: Usa Records para imutabilidade e novas APIs de data.
*   **Spring Boot 3.4.x**: Base do ecossistema da aplicação.
*   **Spring Data JPA**: Camada de persistência com PostgreSQL.
*   **Google Gemini AI (LLM)**: Motor de inteligência artificial para extração de dados em linguagem natural.
*   **MapStruct**: Mapeamento entre Entidades e DTOs.
*   **Apache HttpClient 5**: Camada de transporte customizada para ambientes corporativos.
*   **Bean Validation (Jakarta)**: Regras de negócio validadas diretamente no contrato da API.

### 1. Integração Flexível com IA

A aplicação foi projetada para ser independente de fornecedores de IA. Foi implementada uma camada de comunicação direta via `RestClient` do Spring com a API do **Google Gemini**. Isso garante maior estabilidade em comparação a bibliotecas experimentais.

### 3. Validações Complexas

Implementação de **Constraint Validators** customizados para garantir regras de negócio consistentes, como:

*   Validação de idade mínima (18 anos) baseada na data de nascimento.
*   Consistência de períodos (Data de Início deve ser anterior à Data de Término).
*   Tratamento global de exceções com retornos HTTP semânticos (400, 404, 409).

## 🛠️ Como Executar

1.  Clone o repositório.
2.  Configure o banco de dados PostgreSQL no `application.properties`.
3.  Adicione sua chave do Gemini:

```properties
gemini.api.key=SUA_CHAVE_AQUI
