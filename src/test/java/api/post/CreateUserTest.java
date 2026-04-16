package api.post;

import api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {

    @Test
    void deveCriarPostComSucesso() {

        String body = """
            {
              "title": "Teste API",
              "body": "Criando post via RestAssured",
              "userId": 1
            }
            """;

        given()
                .spec(spec)
                .body(body)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Teste API"))
                .body("body", equalTo("Criando post via RestAssured"))
                .body("userId", equalTo(1))
                .body("id", notNullValue());
    }
}
