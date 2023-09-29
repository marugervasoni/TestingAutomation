package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverviewPage extends BasePage{

    private By overviewMessage = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to ')]");
    private By transferFundsBtn = By.xpath("//a[normalize-space()='Transfer Funds']");
    private By firstAccountOnList = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    private By titleAccountDetails = By.xpath("//h1[normalize-space()='Account Details']");
    private By selectActivityPeriod = By.id("month");
    private By activityPeriodAll = By.xpath("//*[@id=\"month\"]/option[1]");
    private By selectTransactionType = By.id("transactionType");
    private By transactionTypeAll = By.xpath("//*[@id=\"transactionType\"]/option[1]");
    private By goBtn = By.xpath("//input[@value='Go']");

    public AccountsOverviewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String obtenerMessageOverview() throws InterruptedException {
        String res = this.getText(overviewMessage);
        System.out.println("Resultado succes message: " + res);
        Thread.sleep(1000);
        return res;
    }

    public void clickTransferFunds() throws InterruptedException {
        this.clickear(transferFundsBtn);
        Thread.sleep(1000);
    }

    public void clickfirstAccount() throws InterruptedException {
        this.clickear(firstAccountOnList);
        Thread.sleep(1000);
    }

    public String obtenerTitleDetails() throws InterruptedException {
        String res = this.getText(titleAccountDetails);
        System.out.println("Resultado succes message: " + res);
        Thread.sleep(1000);
        return res;
    }

    public void clickActivityPeriod() throws InterruptedException {
        this.clickear(selectActivityPeriod);
        Thread.sleep(1000);
    }

    public void clickAllActivityPeriod() throws InterruptedException {
        this.clickear(activityPeriodAll);
        Thread.sleep(1000);
    }

    public void clickTypeTransaction() throws InterruptedException {
        this.clickear(selectTransactionType);
        Thread.sleep(1000);
    }

    public void clickAllType() throws InterruptedException {
        this.clickear(transactionTypeAll);
        Thread.sleep(1000);
    }

    public void clickGoBtn() throws InterruptedException {
        this.clickear(goBtn);
        Thread.sleep(1000);
    }
}
