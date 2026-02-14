# Selenium Web Automation

![CI](https://github.com/Edsong030/selenium-web-automation/actions/workflows/ci.yml/badge.svg)

Projeto de automação de testes web utilizando **Java, Selenium WebDriver, JUnit 5 e Maven**, seguindo o padrão **Page Object Model (POM)** e boas práticas de automação utilizadas no mercado.

---

## Tecnologias utilizadas

* Java 17
* Selenium WebDriver
* JUnit 5
* Maven
* Page Object Model (POM)
* GitHub Actions (CI)

---

## Arquitetura do projeto

O projeto segue o padrão **Page Object Model**, que separa a lógica de interação com as páginas dos testes, facilitando manutenção e escalabilidade.

```
src/test/java
├── config        # Configuração base do WebDriver
├── pages         # Page Objects
└── tests         # Casos de teste
```

---

## Cenários automatizados

### Login

* Login com usuário válido
* Login com usuário inválido

### Carrinho

* Adicionar produto ao carrinho
* Validar item no carrinho

---

## Site utilizado para testes

Os testes são executados no site de demonstração:

```
https://www.saucedemo.com
```

Credenciais válidas:

```
Usuário: standard_user
Senha: secret_sauce
```

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

O navegador será aberto automaticamente e os testes serão executados.

---

## Integração contínua (CI)

O projeto está preparado para execução automatizada utilizando **GitHub Actions**, permitindo que os testes sejam executados a cada push ou pull request.

---

## Boas práticas aplicadas

* Page Object Model (POM)
* Separação por camadas
* Testes independentes
* Reutilização de código
* Estrutura escalável
* Execução automatizada em CI

---

## Autor

**Edson Gomes**
QA Automation Engineer

LinkedIn:
https://www.linkedin.com/in/edson-gomes-494398208
