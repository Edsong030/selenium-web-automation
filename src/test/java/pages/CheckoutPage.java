import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutForm(String name, String address, String creditCardNumber) {
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement addressField = driver.findElement(By.id("address"));
        WebElement cardField = driver.findElement(By.id("creditCardNumber"));

        nameField.sendKeys(name);
        addressField.sendKeys(address);
        cardField.sendKeys(creditCardNumber);
    }

    public boolean validatePurchase() {
        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
        return confirmationMessage.isDisplayed() && confirmationMessage.getText().contains("Thank you for your purchase!");
    }
}