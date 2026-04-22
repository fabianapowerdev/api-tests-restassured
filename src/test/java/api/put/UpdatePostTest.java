// Define o pacote onde essa classe está localizada.
// Aqui ficam os testes relacionados ao método PUT,
// ou seja, testes de ATUALIZAÇÃO de dados.
package api.put;

// Importa o BaseTest para herdar toda a configuração comum:
// - URL base da API
// - Headers padrão (Content-Type, Authorization)
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

// Importa os matchers do Hamcrest.
// Eles ajudam a validar os valores retornados pela API.
import static org.hamcrest.Matchers.*;


// Classe de teste responsável por validar
// a atualização (PUT) de um post na API.
public class UpdatePostTest extends BaseTest {

    // Anotação que diz ao JUnit:
    // "Esse método é um teste e deve ser executado".
    @Test
    void deveAtualizarPostComSucesso() {

        // ---------------------------------------------------------
        // CORPO (BODY) DA REQUISIÇÃO
        // ---------------------------------------------------------
        // Aqui criamos o corpo da requisição em formato JSON.
        // Esse JSON representa os novos dados do post.
        //
        // Usamos um Text Block do Java (""" """),
        // que facilita escrever JSON de forma legível.
        String body = """
            {
              "id": 1,
              "title": "Teste API Atualizado",
              "body": "Atualizando post via RestAssured",
              "userId": 1
            }
            """;

        // ---------------------------------------------------------
        // given()
        // ---------------------------------------------------------
        // Começamos a montar a requisição HTTP.
        // "given" significa: "Dado que tenho essa configuração..."
        given()

                // Aplica a especificação padrão criada no BaseTest.
                // Isso inclui:
                // - baseUri
                // - headers (Content-Type, Authorization)
                // - token
                .spec(spec)

                // Define o body da requisição.
                // Esse body será enviado no PUT.
                .body(body)

                // -------------------------------------------------
                // when()
                // -------------------------------------------------
                // Aqui informamos a ação que será executada.
                // "when" significa: "Quando eu fizer algo..."
                .when()

                // Executa uma requisição HTTP do tipo PUT.
                // O endpoint chamado é /posts/1,
                // ou seja, estamos atualizando o post com ID 1.
                .put("/posts/1")

                // -------------------------------------------------
                // then()
                // -------------------------------------------------
                // Aqui começam as validações do resultado.
                // "then" significa: "Então o resultado esperado é..."
                .then()

                // Valida que a API respondeu com status HTTP 200.
                // 200 significa que a atualização foi aceita com sucesso.
                .statusCode(200)

                // Valida que o campo "id" retornado no JSON
                // continua sendo 1.
                .body("id", equalTo(1))

                // Valida que o campo "title" foi atualizado corretamente.
                .body("title", equalTo("Teste API Atualizado"))

                // Valida que o campo "body" foi atualizado corretamente.
                .body("body", equalTo("Atualizando post via RestAssured"))

                // Valida que o campo "userId" continua correto.
                .body("userId", equalTo(1));
    }
}