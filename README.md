# Selenium Web Automation

Projeto de automação de testes Web utilizando **Java + Selenium + JUnit 5**, com execução:

* Local
* Headless
* Paralela
* Docker
* Selenium Grid
* Pipeline no GitHub Actions
* Relatórios com Allure

---

## 📌 Tecnologias utilizadas

* Java 17
* Maven
* Selenium WebDriver
* JUnit 5
* Allure Reports
* Docker
* Selenium Grid
* GitHub Actions

---

## 📁 Estrutura do projeto

```
src
 └── test
     ├── java
     │   ├── config
     │   │   └── BaseTest.java
     │   ├── pages
     │   │   ├── LoginPage.java
     │   │   ├── InventoryPage.java
     │   │   ├── CartPage.java
     │   │   └── CheckoutPage.java
     │   ├── tests
     │   │   ├── LoginTest.java
     │   │   ├── CarrinhoTest.java
     │   │   └── CheckoutTest.java
     │   └── utils
     │       └── ConfigReader.java
     └── resources
         └── config.properties
```

---

## ⚙️ Configuração por ambiente

Arquivo:

```
src/test/resources/config.properties
```

Exemplo:

```properties
# Ambiente
environment=qa

# Browser
browser=chrome

# Execução remota (Docker/Grid)
remote=false

# URLs por ambiente
base.url.qa=https://www.saucedemo.com
base.url.prod=https://www.saucedemo.com
```

---

## ▶️ Execução dos testes

### Execução local

```bash
mvn clean test
```

---

### Execução headless

No `config.properties`:

```
headless=true
```

Depois execute:

```bash
mvn clean test
```

---

## 🐳 Execução com Docker + Selenium Grid

### 1. Subir os containers

```bash
docker compose up --build
```

Isso irá:

* Subir o Selenium Grid
* Executar os testes automaticamente

---

### 2. Verificar execução

Logs no terminal ou no Docker Desktop:

```
BUILD SUCCESS
Tests run: 8, Failures: 0, Errors: 0
```

---

## 📊 Relatórios Allure

### Gerar relatório

```bash
mvn allure:serve
```

Ou:

```bash
allure serve target/allure-results
```

---

## 🔁 Execução por tags

Os testes estão organizados por tags:

```
@Tag("web")
```

Executar apenas testes web:

```bash
mvn test -Dgroups=web
```

---

## ⚡ Execução paralela

Configurada via:

```
junit-platform.properties
```

Execução automática em paralelo durante os testes.

---

## 🚀 Pipeline CI/CD

O projeto possui pipeline configurada no **GitHub Actions**.

A pipeline executa automaticamente:

* Build do projeto
* Execução dos testes
* Relatórios

Arquivo:

```
.github/workflows/ci.yml
```

---

## 👨‍💻 Autor

**Edson Gomes**
QA Automation Engineer

* Experiência com BDD, automação web, mobile e API
* Foco em qualidade, CI/CD e testes automatizados
* Pretensão salarial: R$ 8k – R$ 10k

---

## 📈 Próximas evoluções

* Testes de API com RestAssured
* Execução multi-browser
* Paralelismo no Selenium Grid
* Pipeline com relatório Allure publicado
* Testes de segurança

---
