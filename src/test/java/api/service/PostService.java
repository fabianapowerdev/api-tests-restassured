package api.service;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostService {

    private final RequestSpecification spec;

    public PostService(RequestSpecification spec) {
        this.spec = spec;
    }

    public Response createPost(Object payload) {
        return given()
                .spec(spec)
                .body(payload)
                .when()
                .post("/posts");
    }

    public Response updatePost(int id, Object payload) {
        return given()
                .spec(spec)
                .body(payload)
                .when()
                .put("/posts/" + id);
    }

    public Response deletePost(int id) {
        return given()
                .spec(spec)
                .when()
                .delete("/posts/" + id);
    }
}