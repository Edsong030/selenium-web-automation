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

        // Login
        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        // DEBUG 1
        System.out.println("URL após login: " + getDriver().getCurrentUrl());

        // Adicionar produto
        inventoryPage.adicionarProduto();
        inventoryPage.abrirCarrinho();

        // DEBUG 2
        System.out.println("URL após abrir carrinho: " + getDriver().getCurrentUrl());

        // Validação carrinho
        assertTrue(cartPage.produtoEstaNoCarrinho());

        // DEBUG 3
        System.out.println("Tentando clicar no checkout...");

        // CLICA NO CHECKOUT
        cartPage.clicarCheckout();

        // DEBUG 4
        System.out.println("URL após clicar checkout: " + getDriver().getCurrentUrl());

        // Preencher dados
        checkoutPage.preencherDados("Edson", "Gomes", "87000000");
        checkoutPage.finalizarCompra();

        // Validação final
        assertTrue(checkoutPage.compraFinalizadaComSucesso());
    }



    @Test
    public void naoDeveFinalizarCheckoutSemDados() {

        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        // Login
        loginPage.acessarSite();
        loginPage.fazerLogin("standard_user", "secret_sauce");

        // Adicionar produto
        inventoryPage.adicionarProduto();
        inventoryPage.abrirCarrinho();

        // Validação carrinho
        assertTrue(cartPage.produtoEstaNoCarrinho());

        // CLICA NO CHECKOUT
        cartPage.clicarCheckout();

        // Tentar continuar sem dados
        checkoutPage.continuarSemDados();

        // Validação de erro
        assertTrue(checkoutPage.erroVisivel());
    }
}
