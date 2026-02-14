package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By checkoutButton = By.id("checkout");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    private By finishButton = By.id("finish");
    private By successMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void iniciarCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void preencherDados(String nome, String sobrenome, String cep) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(nome);
        driver.findElement(lastName).sendKeys(sobrenome);
        driver.findElement(postalCode).sendKeys(cep);
        driver.findElement(continueButton).click();

        // Espera a página de resumo aparecer
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
    }

    public void finalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public boolean compraFinalizadaComSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    public void continuarSemDados() {
        driver.findElement(By.id("continue")).click();
    }

    public boolean erroVisivel() {
        return driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
    }

}
