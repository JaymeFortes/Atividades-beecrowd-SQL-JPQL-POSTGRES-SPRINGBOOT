# Beecrowd SQL e JPQL Solutions

Este repositório contém soluções para exercícios da plataforma **Beecrowd**, abordando consultas em **SQL raiz** e **JPQL (Java Persistence Query Language)**.

## 📚 Sobre
Este projeto foi criado para armazenar e compartilhar minhas resoluções de exercícios junto ao curso DevSuperior, destacando práticas de consultas relacionais e uso de JPQL com **Spring Data JPA**.

## 🛠️ Tecnologias Utilizadas
- **SQL** (consultas nativas)
- **JPQL** (Java Persistence Query Language)
- **Spring Boot / Spring Data JPA**
- **Java 21**


## 🚀 Como Executar
1. Clone o repositório:
   ```bash
   git clone 
   ```
2. Importe o projeto em sua IDE (ex: IntelliJ, Eclipse).
3. Configure a conexão com seu banco de dados (`application.properties`).
4. Execute os testes ou consultas diretamente.

## 📈 Exemplos
### SQL Raiz:
```sql
SELECT enome, dnome
FROM empregados
JOIN departamentos ON empregados.dnumero = departamentos.dnumero;
```
### JPQL:
```java
@Query("SELECT new com.exemplo.dto.EmpregoDeptDTO(e.cpf, e.enome, d.dnome) FROM Empregado e JOIN e.departamento d")
List<EmpregoDeptDTO> buscarEmpregos();
```

## 🌟 Contribuições
Sinta-se à vontade para contribuir com sugestões, melhorias ou novas soluções!

## 📄 Licença
Este projeto está sob a licença MIT.

---
**Desenvolvido com ❤️ por [Jayme Fortes](https://github.com/seu-usuario)**

