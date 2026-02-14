package tests;

import config.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarrinhoTest extends BaseTest {

    @Test
    public void deveAdicionarProdutoAoCarrinho() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        inventoryPage.adicionarProduto();
        inventoryPage.abrirCarrinho();

        assertTrue(cartPage.produtoEstaNoCarrinho());
    }
}
