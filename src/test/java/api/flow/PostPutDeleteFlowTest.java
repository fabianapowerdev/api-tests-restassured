package api.flow;

import api.base.BaseTest;
import api.payload.PostPayload;
import api.service.PostService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class PostPutDeleteFlowTest extends BaseTest {

    @Test
    void deveExecutarFluxoPostPutDeleteComSucesso() {

        // 1️⃣ Cria o service (usa spec do BaseTest)
        PostService postService = new PostService(spec);

        // =========================
        // POST - cria recurso
        // =========================
        Response postResponse =
                postService.createPost(PostPayload.create())
                        .then()
                        .statusCode(201)
                        .extract()
                        .response();

        int createdId = postResponse.jsonPath().getInt("id");
        System.out.println("ID criado (mock): " + createdId);

        // =========================
        // IMPORTANTE:
        // JSONPlaceholder não mantém estado real.
        // PUT/DELETE dinâmico gera erro.
        // =========================
        int fixedId = 1;

        // =========================
        // PUT - atualiza recurso
        // =========================
        postService.updatePost(fixedId, PostPayload.update(fixedId))
                .then()
                .statusCode(200);

        // =========================
        // DELETE - remove recurso
        // =========================
        postService.deletePost(fixedId)
                .then()
                .statusCode(200);
    }
}
