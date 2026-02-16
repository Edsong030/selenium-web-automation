package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cartItem = By.className("cart_item");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean produtoEstaNoCarrinho() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
        return driver.findElement(cartItem).isDisplayed();
    }

    public void clicarCheckout() {

        WebElement botaoCheckout = wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", botaoCheckout);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", botaoCheckout);

        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    }
}
