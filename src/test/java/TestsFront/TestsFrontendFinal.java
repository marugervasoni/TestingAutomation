package TestsFront;

import Pages.*;
import Reportes.ExtentFactory;
import Utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsFrontendFinal {

    public WebDriver driver;
    public WebDriverWait wait;
    ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES.html");
    ExtentReports extent;

    @BeforeEach
    public void setUp() throws InterruptedException {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        HomePage homePage = new HomePage(driver,wait);
        homePage.setup();
        homePage.url(Constants.Endpoints.HOME_PAGE);
    }

    @Test
	@Tag("SMOKE-FRONT")
    public void ProcesoDeRegistroAperturaResumenTransferenciaYActividadDeLaCuenta() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro, Apertura de cuenta, Resumen, Transferencia de fondos y Actividad de la cuenta");
        test.log(Status.INFO, "Comienza el Test");
        HomePage homePage = new HomePage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        OpenAccountPage openAccountPage = new OpenAccountPage(driver, wait);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver, wait);
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver, wait);

        homePage.clickRegister();
        test.log(Status.INFO, "Ingreso en el formulario de Registro");
        registerPage.escribirFirstname("Maru");
        registerPage.escribirLastname("Gervasoni");
        registerPage.escribirAddress("calle falsa 123");
        registerPage.escribirCity("Buenos Aires");
        registerPage.escribirState("Argentina");
        registerPage.escribirZipCode("1609");
        registerPage.escribirPhone("12345678");
        registerPage.escribirSsn("12345");
        registerPage.escribirUsername("marug");
        registerPage.escribirPassword("password");
        registerPage.escribirRepassword("password");
        test.log(Status.INFO, "Ingreso todos los datos del Registro");
        registerPage.clickRegisterBtn();;

        String resultadoEsperado = registerPage.obtenerSuccesRegister();
        assertTrue(resultadoEsperado.contains("Your account was created successfully"));
        test.log(Status.PASS, "PROCESO DE REGISTRO COMPLETO");



        registerPage.clickOpenAccountBtn();
        test.log(Status.INFO, "Ingreso a Página Abrir Nueva Cuenta");
        openAccountPage.clickSelectTypeAccount();
        openAccountPage.clickSelectTypeSavings();
        openAccountPage.clickOpenNewAccount();

        String resultadoEsperado2 = openAccountPage.obtenerCreatedAccount();
        assertTrue(resultadoEsperado2.contains("Congratulations, your account is now open."));
        test.log(Status.PASS, "PROCESO DE APERTURA DE CUENTA COMPLETO");



        openAccountPage.clickAccountsOverview();
        test.log(Status.INFO, "Ingreso a Página Resumen de cuenta ");

        String resultadoEsperado3 = accountsOverviewPage.obtenerMessageOverview();
        assertTrue(resultadoEsperado3.contains("Balance includes deposits that"));
        test.log(Status.PASS, "PROCESO DE RESUMEN DE CUENTA COMPLETO");



        accountsOverviewPage.clickTransferFunds();
        test.log(Status.INFO, "Ingredo a Página Transferencia de fondos ");

        String resultadoEsperado4 = transferFundsPage.obtenerTituloTransfer();
        assertTrue(resultadoEsperado4.contains("Transfer Funds"));

        transferFundsPage.escribirAmount("50.00");
        transferFundsPage.clickSelectFromAccount();
        transferFundsPage.clickFirtsOptionFromAccount();
        transferFundsPage.clickSelectToAccount();
        transferFundsPage.clickSecondOptionToAccount();
        test.log(Status.INFO, "Ingreso todos los datos de Transferencia");
        transferFundsPage.clickTransferBtn();

        String resultadoEsperado5 = transferFundsPage.obtenerTituloSuccesTransfer();
        assertTrue(resultadoEsperado5.contains("Transfer Complete!"));
        test.log(Status.PASS, "PROCESO DE TRANSFERENCIA DE FONDOS COMPLETO");



        transferFundsPage.clickAccountsOverview();
        test.log(Status.INFO, "Ingreso a Página Resumen de cuenta");

        String resultadoEsperado6 = accountsOverviewPage.obtenerMessageOverview();
        assertTrue(resultadoEsperado6.contains("Balance includes deposits that"));

        accountsOverviewPage.clickfirstAccount();

        String resultadoEsperado7 = accountsOverviewPage.obtenerTitleDetails();
        assertTrue(resultadoEsperado7.contains("Account Details"));

        accountsOverviewPage.clickActivityPeriod();
        accountsOverviewPage.clickAllActivityPeriod();
        accountsOverviewPage.clickTypeTransaction();
        accountsOverviewPage.clickAllType();
        test.log(Status.INFO, "Ingreso todos los datos de visualización de actividad");
        accountsOverviewPage.clickGoBtn();
        test.log(Status.PASS, "PROCESO DE ACTIVIDAD DE LA CUENTA COMPLETO");
        test.log(Status.PASS, "TEST COMPLETO");
    }

    @AfterEach
    public void cerrar() {
        HomePage homePage = new HomePage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        OpenAccountPage openAccountPage = new OpenAccountPage(driver,wait);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver, wait);
        TransferFundsPage  transferFundsPage = new TransferFundsPage(driver, wait);
        homePage.close();
        registerPage.close();
        openAccountPage.close();
        accountsOverviewPage.close();
        transferFundsPage.close();
        extent.flush();
    }
}