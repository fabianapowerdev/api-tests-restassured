package api.schema;

import api.base.BaseTest;
import api.payload.PostPayload;
import api.service.PostService;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostSchemaTest extends BaseTest {

    @Test
    void deveValidarSchemaDoPostComSucesso() {

        PostService postService = new PostService(spec);

        postService.createPost(PostPayload.create())
                .then()
                .statusCode(201)
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }
}
