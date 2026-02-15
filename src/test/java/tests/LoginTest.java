package tests;

import org.junit.jupiter.api.Tag;
import config.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("web")
public class LoginTest extends BaseTest {

    @Test
    public void deveRealizarLoginComSucesso() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        assertTrue(loginPage.loginRealizadoComSucesso());
    }

    @Test
    public void naoDeveLogarComCredenciaisInvalidas() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.acessarSite();
        loginPage.fazerLogin("usuario_errado", "senha_errada");

        assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }
    @Test
    public void naoDeveLogarComUsuarioBloqueado() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.acessarSite();
        loginPage.fazerLogin("locked_out_user", "secret_sauce");

        // Validação de erro
        assertTrue(loginPage.mensagemErroVisivel());
    }
    @Test
    public void naoDeveLogarComSenhaIncorreta() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "senha_errada");

        // Validação de erro
        assertTrue(loginPage.mensagemErroVisivel());
    }



}
