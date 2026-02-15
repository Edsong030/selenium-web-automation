package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By inventoryTitle = By.className("title");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public void acessarSite() {
        driver.get(utils.ConfigReader.getUrl());
    }


    public void fazerLogin(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public boolean loginRealizadoComSucesso() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryTitle));
        return driver.findElement(inventoryTitle).getText().equals("Products");
    }

    public boolean mensagemErroVisivel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }
}
