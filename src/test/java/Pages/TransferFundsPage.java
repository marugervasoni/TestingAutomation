package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage extends BasePage{

    private By titleTransferFunds = By.xpath("//h1[normalize-space()='Transfer Funds']");
    private By formAmount = By.id("amount");
    private By selectFromAccount = By.id("fromAccountId");
    private By firstFromAccount = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");
    private By selectToAccount = By.id("toAccountId");
    private By secondToAccount = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    private By transferBtn = By.xpath("//input[@value='Transfer']");
    private By titleSuccesTransfer = By.xpath("//h1[normalize-space()='Transfer Complete!']");
    private By accountsOvervBtn = By.xpath("//a[normalize-space()='Accounts Overview']");

    public TransferFundsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String obtenerTituloTransfer() throws InterruptedException {
        String res = this.getText(titleTransferFunds);
        System.out.println("Resultado succes message: " + res);
        Thread.sleep(1000);
        return res;
    }

    public void escribirAmount(String monto) throws InterruptedException {
        this.sendText(monto, formAmount);
    }

    public void clickSelectFromAccount() throws InterruptedException {
        this.clickear(selectFromAccount);
        Thread.sleep(1000);
    }

    public void clickFirtsOptionFromAccount() throws InterruptedException {
        this.clickear(firstFromAccount);
        Thread.sleep(1000);
    }

    public void clickSelectToAccount() throws InterruptedException {
        this.clickear(selectToAccount);
        Thread.sleep(1000);
    }

    public void clickSecondOptionToAccount() throws InterruptedException {
        this.clickear(secondToAccount);
        Thread.sleep(1000);
    }

    public void clickTransferBtn() throws InterruptedException {
        this.clickear(transferBtn);
        Thread.sleep(1000);
    }

    public String obtenerTituloSuccesTransfer() throws InterruptedException {
        String res = this.getText(titleSuccesTransfer);
        System.out.println("Resultado succes message: " + res);
        Thread.sleep(1000);
        return res;
    }

    public void clickAccountsOverview() throws InterruptedException {
        this.clickear(accountsOvervBtn);
        Thread.sleep(1000);
    }
}
