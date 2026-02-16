package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By successMessage = By.className("complete-header");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void preencherDados(String nome, String sobrenome, String cep) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(nome);

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(sobrenome);

        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(cep);

        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();

        // Aguarda realmente mudar de página
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
    }


    public void finalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        driver.findElement(finishButton).click();
    }

    public boolean compraFinalizadaComSucesso() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }

    public void continuarSemDados() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    public boolean erroVisivel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return true;
    }


}
