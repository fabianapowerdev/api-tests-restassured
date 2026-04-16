package api.get;

import api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    void deveBuscarUsuarioComSucesso() {

        given()
                .spec(spec)
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", notNullValue());
    }
}