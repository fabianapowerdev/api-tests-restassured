// Define o pacote onde essa classe está.
// Aqui ficam os "services", ou seja, classes que sabem falar com a API.
package api.service;

// Importa Response, que representa a resposta da API.
// Um Response pode conter: status code, body, headers, etc.
import io.restassured.response.Response;

// Importa RequestSpecification, que é a configuração padrão da requisição.
// Ela já contém baseUri, headers, token, SSL, etc.
import io.restassured.specification.RequestSpecification;

// Importa o método given() do RestAssured.
// given() é o ponto inicial para montar uma requisição HTTP.
import static io.restassured.RestAssured.given;


// Classe "PostService" responsável por executar chamadas HTTP relacionadas a "posts".
// Importante: esta classe NÃO faz validação (assert).
// Ela apenas executa as requisições e devolve a resposta.
public class PostService {

    // Guarda a configuração padrão da requisição (spec).
    // Ela vem do BaseTest e tem:
    // - baseUri
    // - headers
    // - token
    // - SSL relaxado (se configurado)
    private final RequestSpecification spec;

    // ---------------------------------------------------------
    // CONSTRUTOR
    // ---------------------------------------------------------
    // Recebe a spec pronta (vinda do BaseTest) e guarda na classe.
    // Assim todos os métodos daqui vão usar a mesma configuração.
    public PostService(RequestSpecification spec) {
        this.spec = spec;
    }

    // ---------------------------------------------------------
    // MÉTODO: CREATE (POST)
    // ---------------------------------------------------------
    // Faz uma requisição POST para criar um post.
    //
    // - Recebe um payload (o corpo da requisição).
    // - Retorna a resposta da API (Response).
    //
    // Object payload significa que você pode passar:
    // - String (JSON pronto)
    // - Map (ex: PostPayload.create())
    // - POJO (classe Java) se quiser futuramente
    public Response createPost(Object payload) {

        // given(): monta a requisição
        return given()

                // Usa a spec padrão (baseUri, headers, token, etc.)
                .spec(spec)

                // Define o body da requisição
                .body(payload)

                // when(): executa a ação
                .when()

                // POST no endpoint /posts
                // (a baseUri já vem do spec, então aqui usamos só o caminho)
                .post("/posts");
    }

    // ---------------------------------------------------------
    // MÉTODO: UPDATE (PUT)
    // ---------------------------------------------------------
    // Faz uma requisição PUT para atualizar um post específico.
    //
    // - Recebe o id do post que será atualizado
    // - Recebe o payload (os novos dados)
    // - Retorna a resposta da API
    public Response updatePost(int id, Object payload) {

        return given()
                .spec(spec)
                .body(payload)
                .when()

                // PUT no endpoint /posts/{id}
                // Aqui o id é concatenado para formar o caminho.
                .put("/posts/" + id);
    }

    // ---------------------------------------------------------
    // MÉTODO: DELETE
    // ---------------------------------------------------------
    // Faz uma requisição DELETE para remover um post específico.
    //
    // - Recebe o id do post que será removido
    // - Retorna a resposta da API
    public Response deletePost(int id) {

        return given()
                .spec(spec)
                .when()

                // DELETE no endpoint /posts/{id}
                .delete("/posts/" + id);
    }
}