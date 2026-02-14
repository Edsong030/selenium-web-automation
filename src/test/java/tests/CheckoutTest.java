package tests;

import config.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void deveFinalizarCompraComSucesso() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        // Adicionar produto
        inventoryPage.adicionarProduto();
        inventoryPage.abrirCarrinho();

        // Validação carrinho
        assertTrue(cartPage.produtoEstaNoCarrinho());

        // Checkout
        checkoutPage.iniciarCheckout();
        checkoutPage.preencherDados("Edson", "Gomes", "87000-000");
        checkoutPage.finalizarCompra();

        // Validação final
        assertTrue(checkoutPage.compraFinalizadaComSucesso());
    }
}
