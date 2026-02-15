package tests.api;

import org.junit.jupiter.api.Tag;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class UsuarioApiTest {

    private final String BASE_URL = "https://serverest.dev";

    @Test
    public void deveExecutarFluxoCompletoDeUsuario() {

        // 1. Criar usuário
        String email = "edson" + System.currentTimeMillis() + "@qa.com";

        Response createResponse =
                given()
                        .baseUri(BASE_URL)
                        .contentType("application/json")
                        .body("""
                                {
                                  "nome": "Edson QA",
                                  "email": "%s",
                                  "password": "123456",
                                  "administrador": "true"
                                }
                                """.formatted(email))
                        .when()
                        .post("/usuarios")
                        .then()
                        .statusCode(201)
                        .body("message", equalTo("Cadastro realizado com sucesso"))
                        .extract()
                        .response();

        String userId = createResponse.path("_id");

        // 2. Buscar usuário por ID
        given()
                .baseUri(BASE_URL)
                .when()
                .get("/usuarios/" + userId)
                .then()
                .statusCode(200)
                .body("nome", equalTo("Edson QA"))
                .body("email", equalTo(email));

        // 3. Deletar usuário
        given()
                .baseUri(BASE_URL)
                .when()
                .delete("/usuarios/" + userId)
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));
    }
}
