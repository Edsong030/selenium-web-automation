package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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

        WebElement botaoContinue = wait.until(
                ExpectedConditions.visibilityOfElementLocated(continueButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", botaoContinue);

        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void continuarSemDados() {
        WebElement botaoContinue = wait.until(
                ExpectedConditions.visibilityOfElementLocated(continueButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", botaoContinue);

        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }

    public void finalizarCompra() {
        WebElement botaoFinish = wait.until(
                ExpectedConditions.visibilityOfElementLocated(finishButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", botaoFinish);

        wait.until(ExpectedConditions.urlContains("checkout-complete"));
    }

    public boolean compraFinalizadaComSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    public boolean erroVisivel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }
}
