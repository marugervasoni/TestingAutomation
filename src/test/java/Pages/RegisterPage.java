package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private By firstname = By.id("customer.firstName");
    private By lastname = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipcode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By repassword = By.id("repeatedPassword");
    private By registerBtn = By.xpath("//input[@value='Register']");
    private By succesRegister = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");
    private By openAccountBtn = By.xpath("//a[normalize-space()='Open New Account']");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void escribirFirstname(String nombre) throws InterruptedException {
        this.sendText(nombre, firstname);
    }

    public void escribirLastname(String apellido) throws InterruptedException {
        this.sendText(apellido, lastname);
    }

    public void escribirAddress(String direcc) throws InterruptedException {
        this.sendText(direcc, address);
    }

    public void escribirCity(String ciudad) throws InterruptedException {
        this.sendText(ciudad, city);
    }

    public void escribirState(String pais) throws InterruptedException {
        this.sendText(pais, state);
    }

    public void escribirZipCode(String codPost) throws InterruptedException {
        this.sendText(codPost, zipcode);
    }

    public void escribirPhone(String tel) throws InterruptedException {
        this.sendText(tel, phone);
    }

    public void escribirSsn(String segusoSocNum) throws InterruptedException {
        this.sendText(segusoSocNum, ssn);
    }

    public void escribirUsername(String usuario) throws InterruptedException {
        this.sendText(usuario, username);
    }

    public void escribirPassword(String contra) throws InterruptedException {
        this.sendText(contra, password);
    }

    public void escribirRepassword(String repass) throws InterruptedException {
        this.sendText(repass, repassword);
    }

    public void clickRegisterBtn() throws InterruptedException {
        this.clickear(registerBtn);
        Thread.sleep(2000);
    }

    public String obtenerSuccesRegister() throws InterruptedException {
        String res = this.getText(succesRegister);
        System.out.println("Resultado succes message: " + res);
        Thread.sleep(1000);
        return res;
    }

    public void clickOpenAccountBtn() throws InterruptedException {
        this.clickear(openAccountBtn);
        Thread.sleep(1000);
    }

}