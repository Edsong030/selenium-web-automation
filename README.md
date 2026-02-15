# 🧪 Selenium Web Automation + API Tests

Projeto de automação de testes **Web e API** utilizando **Java, Selenium, JUnit 5, RestAssured, Allure e GitHub Actions**.

O objetivo deste projeto é demonstrar boas práticas de automação, arquitetura de testes e integração contínua.

---

## 🚀 Tecnologias utilizadas

* Java 17
* Selenium WebDriver
* JUnit 5
* RestAssured
* Maven
* Allure Reports
* GitHub Actions (CI)

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
     │   │   ├── CheckoutTest.java
     │   │   └── api
     │   │       └── UsuarioApiTest.java
     │   └── utils
     │       ├── ConfigReader.java
     │       ├── ScreenshotUtil.java
     │       ├── AllureUtil.java
     │       └── TestListener.java
     └── resources
         ├── config.properties
         └── junit-platform.properties
```

---

## 🔧 Como executar o projeto

### Pré-requisitos

* Java 17 instalado
* Maven instalado
* Google Chrome instalado

---

### Executar todos os testes

```bash
mvn clean test
```

---

## 📊 Gerar relatório Allure

Após executar os testes:

```bash
allure serve allure-results
```

O relatório abrirá automaticamente no navegador.

---

## 🔁 Integração contínua

O projeto possui pipeline configurada no **GitHub Actions**:

* Executa os testes automaticamente a cada push
* Garante a estabilidade da automação

Arquivo de configuração:

```
.github/workflows/ci.yml
```

---

## 🧪 Cenários automatizados

### Web (Selenium)

**Login**

* Login com sucesso
* Login com senha incorreta
* Login com usuário bloqueado
* Login com credenciais inválidas

**Carrinho**

* Adicionar produto ao carrinho

**Checkout**

* Finalizar compra com sucesso
* Tentar finalizar checkout sem dados

---

### API (RestAssured)

**Usuários**

* Criar usuário com sucesso
* Validar criação com dados inválidos
* Buscar usuário por ID

---

## 🧱 Boas práticas aplicadas

* Page Object Model (POM)
* Separação de camadas (pages, tests, utils, config)
* Configuração externa via properties
* Captura de screenshot automática
* Relatórios com Allure
* Pipeline CI no GitHub Actions

---

## 👨‍💻 Autor

**Edson Gomes**
QA Engineer com experiência em automação de testes Web, Mobile e API.

🔗 GitHub:
https://github.com/Edsong030

---

## 🎯 Objetivo do projeto

Este projeto foi criado para:

* Demonstrar conhecimentos em automação de testes
* Aplicar boas práticas de arquitetura de testes
* Simular um ambiente real de projeto com CI/CD
* Servir como portfólio técnico para vagas de QA
