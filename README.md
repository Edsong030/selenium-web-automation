# Automação Web com Selenium

![CI](https://github.com/Edsong030/selenium-web-automation/actions/workflows/ci.yml/badge.svg)

Projeto de automação de testes web utilizando **Java, Selenium WebDriver, JUnit 5 e Maven**, seguindo o padrão **Page Object Model (POM)** e boas práticas utilizadas no mercado.

---

## Tecnologias utilizadas

* Java 17
* Selenium WebDriver
* JUnit 5
* Maven
* GitHub Actions (CI)
* Allure Report

---

## Arquitetura do projeto

O projeto segue o padrão **Page Object Model (POM)** para facilitar manutenção e escalabilidade dos testes.

```
src/test/java
├── config        # Configurações do WebDriver
├── pages         # Page Objects
│   ├── LoginPage.java
│   ├── InventoryPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
└── tests         # Casos de teste
    ├── LoginTest.java
    ├── CarrinhoTest.java
    └── CheckoutTest.java
```

---

## Cenários automatizados

### Login

* Login com sucesso
* Login com usuário inválido

### Carrinho

* Adicionar produto ao carrinho
* Validar item no carrinho

### Checkout

* Preencher dados do cliente
* Finalizar compra com sucesso
* Validar mensagem de confirmação

---

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Edsong030/selenium-web-automation.git
```

### 2. Acessar a pasta do projeto

```bash
cd selenium-web-automation
```

### 3. Executar os testes

```bash
mvn clean test
```

---

## Relatório com Allure

### Gerar relatório localmente

```bash
allure serve target/allure-results
```

O relatório exibirá:

* Cenários executados
* Passos do teste
* Status (passou/falhou)
* Tempo de execução

---

## Integração contínua (CI)

O projeto possui pipeline no **GitHub Actions** que:

* Executa os testes automaticamente
* Roda a cada push ou pull request
* Mostra o status do build no badge do README

---

## Boas práticas aplicadas

* Page Object Model (POM)
* Separação de responsabilidades
* Testes independentes
* Configuração centralizada do WebDriver
* Execução automatizada via CI

---

## Autor

**Edson Gomes**
QA Automation Engineer

LinkedIn:
https://www.linkedin.com/in/edson-gomes-494398208
