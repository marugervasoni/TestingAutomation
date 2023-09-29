package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By btnRegister = By.xpath("//a[normalize-space()='Register']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickRegister() throws InterruptedException {
        this.clickear(btnRegister);
        Thread.sleep(1000);
    }
}
