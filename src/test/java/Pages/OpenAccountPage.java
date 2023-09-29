package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage extends BasePage{

    private By selectTypeAccount = By.xpath("//select[@id='type']");
    private By selectSavings = By.xpath("//*[@id=\"type\"]/option[2]");
    private By openNewAccountBtn = By.xpath("//input[@value='Open New Account']");
    private By succesCreateAccount = By.xpath("//p[normalize-space()='Congratulations, your account is now open.']");
    private By accountsOvervBtn = By.xpath("//a[normalize-space()='Accounts Overview']");

    public OpenAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickSelectTypeAccount() throws InterruptedException {
        this.clickear(selectTypeAccount);
        Thread.sleep(1000);
    }

    public void clickSelectTypeSavings() throws InterruptedException {
        this.clickear(selectSavings);
        Thread.sleep(1000);
    }

    public void clickOpenNewAccount() throws InterruptedException {
        this.clickear(openNewAccountBtn);
        Thread.sleep(1000);
    }

    public String obtenerCreatedAccount() throws InterruptedException {
        String res = this.getText(succesCreateAccount);
        System.out.println("Resultado succes message: " + res);
        Thread.sleep(1000);
        return res;
    }

    public void clickAccountsOverview() throws InterruptedException {
        this.clickear(accountsOvervBtn);
        Thread.sleep(1000);
    }

}
