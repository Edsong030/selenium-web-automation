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
    private By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void adicionarProduto() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpack)).click();

        // Aguarda o número aparecer no carrinho (garante que adicionou)
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
    }

    public void abrirCarrinho() {
        WebElement carrinho = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartIcon)
        );

        // Clique via JavaScript (mais estável no CI)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", carrinho);

        wait.until(ExpectedConditions.urlContains("cart.html"));
    }
}
