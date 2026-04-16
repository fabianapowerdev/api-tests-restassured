package api.put;

import api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdatePostTest extends BaseTest {

    @Test
    void deveAtualizarPostComSucesso() {

        String body = """
            {
              "id": 1,
              "title": "Teste API Atualizado",
              "body": "Atualizando post via RestAssured",
              "userId": 1
            }
            """;

        given()
                .spec(spec)
                .body(body)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", equalTo("Teste API Atualizado"))
                .body("body", equalTo("Atualizando post via RestAssured"))
                .body("userId", equalTo(1));
    }
}
