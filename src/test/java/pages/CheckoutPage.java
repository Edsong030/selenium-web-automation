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

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(nome);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(sobrenome);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode)).sendKeys(cep);

        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

        // espera a próxima página
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void continuarSemDados() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }

    public void finalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
        wait.until(ExpectedConditions.urlContains("checkout-complete"));
    }

    public boolean compraFinalizadaComSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    public boolean erroVisivel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }
}
