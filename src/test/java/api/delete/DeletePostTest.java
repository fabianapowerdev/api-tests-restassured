package api.delete;

import api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeletePostTest extends BaseTest {

    @Test
    void deveDeletarPostComSucesso() {

        given()
                .spec(spec)
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);
    }
}