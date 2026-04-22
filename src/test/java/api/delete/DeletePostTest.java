// Define o pacote onde esta classe está.
// Aqui ficam os testes relacionados ao método DELETE.
package api.delete;

// Importa a BaseTest para herdar toda a configuração padrão:
// - URL base da API
// - Headers (Content-Type, Authorization)
// - Token de autenticação
// - Configuração de SSL
// - Logs automáticos em caso de erro
import api.base.BaseTest;

// Importa a anotação @Test do JUnit.
// Ela indica que o método abaixo é um teste automatizado.
import org.junit.jupiter.api.Test;

// Importa o método given() do RestAssured.
// given() é o ponto de partida para montar uma requisição HTTP.
import static io.restassured.RestAssured.given;


// Classe de teste responsável por validar o DELETE de um post.
// Ela herda BaseTest, então já vem "pronta" para chamar a API.
public class DeletePostTest extends BaseTest {

    // Anotação que diz ao JUnit:
    // "Esse método é um teste e deve ser executado".
    @Test
    void deveDeletarPostComSucesso() {

        // ---------------------------------------------------------
        // given()
        // ---------------------------------------------------------
        // Aqui começamos a montar a requisição HTTP.
        // "given" significa: "Dado que tenho essa configuração..."
        given()

                // Aplica a especificação padrão criada no BaseTest.
                // Isso inclui:
                // - baseUri
                // - headers
                // - token de autenticação
                .spec(spec)

                // -------------------------------------------------
                // when()
                // -------------------------------------------------
                // Indica a ação que será executada.
                // Aqui estamos dizendo: "Quando eu fizer algo..."
                .when()

                // Executa uma requisição HTTP do tipo DELETE.
                // O endpoint usado é /posts/1
                // Nesse caso, estamos simulando a exclusão do post com ID 1.
                .delete("/posts/1")

                // -------------------------------------------------
                // then()
                // -------------------------------------------------
                // Aqui começam as validações.
                // "then" significa: "Então o resultado esperado é..."
                .then()

                // Valida que a API respondeu com status HTTP 200.
                // 200 significa que a requisição foi aceita com sucesso.
                .statusCode(200);
    }
}