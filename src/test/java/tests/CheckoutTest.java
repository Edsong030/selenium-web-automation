package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void iniciarCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();
    }

    public void preencherDados(String nome, String sobrenome, String cep) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys(nome);
        driver.findElement(By.id("last-name")).sendKeys(sobrenome);
        driver.findElement(By.id("postal-code")).sendKeys(cep);
        driver.findElement(By.id("continue")).click();
    }

    public void continuarSemDados() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
    }

    public void finalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
    }

    public boolean compraFinalizadaComSucesso() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))
        ).isDisplayed();
    }

    public boolean erroVisivel() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']"))
        ).isDisplayed();
    }
}
