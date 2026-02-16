package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
        WebElement carrinho = wait.until(
                ExpectedConditions.elementToBeClickable(cartIcon)
        );

        // Garante que o elemento esteja visível na tela
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", carrinho);

        carrinho.click();

        // Aguarda navegação
        wait.until(ExpectedConditions.urlContains("cart.html"));
    }

}
