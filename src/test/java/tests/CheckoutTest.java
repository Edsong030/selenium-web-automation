package tests;

import config.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("web")
public class CheckoutTest extends BaseTest {

    @Test
    public void deveFinalizarCompraComSucesso() {

        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        inventoryPage.adicionarProduto();
        inventoryPage.abrirCarrinho();

        assertTrue(cartPage.produtoEstaNoCarrinho());

        cartPage.clicarCheckout();

        checkoutPage.preencherDados("Edson", "Gomes", "87000000");
        checkoutPage.finalizarCompra();

        assertTrue(checkoutPage.compraFinalizadaComSucesso());
    }

    @Test
    public void naoDeveFinalizarCheckoutSemDados() {

        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        inventoryPage.adicionarProduto();
        inventoryPage.abrirCarrinho();

        assertTrue(cartPage.produtoEstaNoCarrinho());

        cartPage.clicarCheckout();

        checkoutPage.continuarSemDados();

        assertTrue(checkoutPage.erroVisivel());
    }
}
