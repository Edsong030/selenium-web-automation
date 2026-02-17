package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    // Locators
    private By cartItems = By.cssSelector(".cart-item");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to validate if the cart has items
    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    // Method to click on the checkout button
    public void clickCheckout() {
        WebElement checkout = driver.findElement(checkoutButton);
        if (checkout.isDisplayed() && checkout.isEnabled()) {
            checkout.click();
        }
    }
}