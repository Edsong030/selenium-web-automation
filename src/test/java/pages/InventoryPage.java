package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpack = By.id("remove-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void adicionarProduto() {
        driver.findElement(addBackpack).click();
    }

    public void removerProduto() {
        driver.findElement(removeBackpack).click();
    }

    public void abrirCarrinho() {
        driver.findElement(cartIcon).click();
    }
}
