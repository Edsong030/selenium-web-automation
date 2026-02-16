package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.cssSelector(".shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void adicionarProduto() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpack)).click();
    }

    public void abrirCarrinho() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();

        // GARANTE que foi para o carrinho
        wait.until(ExpectedConditions.urlContains("cart.html"));
    }
}
