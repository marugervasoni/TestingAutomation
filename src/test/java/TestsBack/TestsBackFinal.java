package TestsBack;

import Utils.Constants;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestsBackFinal {

    String accountId;
    String customerId;
    String account2Id;

    @BeforeEach
    public void setUp() {
        Response response = RestAssured.given()
                .redirects().follow(true)
                .get(Constants.Endpoints.LOGIN + "marug/password");

        System.out.println(response.getBody().asString());
        XmlPath xmlPath = new XmlPath(response.getBody().asString());
        customerId = xmlPath.getString("customer.id");
        System.out.println(customerId);

        String urlAccount = Constants.Endpoints.ACCOUNT + customerId + "/accounts";

        Response response2 = RestAssured.given()
                .redirects().follow(true)
                .get(urlAccount);

        System.out.println(response2.getBody().asString());
        XmlPath xmlPath2 = new XmlPath(response2.getBody().asString());
        accountId = xmlPath2.getString("accounts.account[0].id");
        account2Id = xmlPath2.getString("accounts.account[1].id");

        System.out.println(accountId);
        System.out.println(account2Id);
    }

    @Test
    @Tag("SMOKE-BACK")
    @Order(1)
    public void Registro() {

        given()
                .when()
                .get(Constants.Endpoints.REGISTER_PAGE)
                .then()
                .statusCode(200)
                .log().body();

    }

    @Test
    @Tag("SMOKE-BACK")
    @Order(2)
    public void AperturaDeCuenta() {

        given()
                .queryParam("customerId", customerId)
                .queryParam("NewAccountType", "1")
                .queryParam("fromAccountId", accountId)
                .when()
                .post(Constants.Endpoints.CREATE_ACCOUNT)
                .then()
                .statusCode(200)
                .log().status()
                .log().body(false);
    }

    @Test
    @Tag("SMOKE-BACK")
    @Order(3)
    public void ResumenDeCuenta() {
        given()
                .when()
                .get(Constants.Endpoints.ACCOUNT + customerId + "/accounts")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    @Tag("SMOKE-BACK")
    @Order(4)
    public void DescargaDeFondos() {
        given()
                .queryParam("fromAccountId", accountId)
                .queryParam("toAccountId", account2Id)
                .queryParam("amount", "50.00")
                .when()
                .post(Constants.Endpoints.TRANSFER_FUNDS)
                .then()
                .statusCode(200)
                .log().status()
                .log().body(false);

    }

    @Test
    @Tag("SMOKE-BACK")
    @Order(5)
    public void ActividadDeLaCuenta() {
        given()
                .when()
                .get(Constants.Endpoints.ACCOUNT_ACTIVITY + customerId + Constants.Endpoints.ALL_TRANSACTIONS_ALL_TYPE)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
