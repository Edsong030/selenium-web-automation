package tests;

import org.junit.jupiter.api.Tag;
import config.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("web")
public class CarrinhoTest extends BaseTest {

    @Test
    public void deveAdicionarProdutoAoCarrinho() {

        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        inventoryPage.adicionarProduto();
        inventoryPage.abrirCarrinho();

        assertTrue(cartPage.produtoEstaNoCarrinho());
    }
}
