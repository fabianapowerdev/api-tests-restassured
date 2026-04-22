// Define o pacote onde essa classe está localizada.
// Aqui ficam os testes relacionados ao método POST,
// ou seja, testes de criação de dados.
package api.post;

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
// given() é o ponto inicial para montar uma requisição HTTP.
import static io.restassured.RestAssured.given;

// Importa matchers do Hamcrest.
// Eles são usados para validar os valores retornados pela API.
import static org.hamcrest.Matchers.*;


// Classe de teste responsável por validar
// a criação de um post via POST.
public class CreateUserTest extends BaseTest {

    // Anotação que diz ao JUnit:
    // "Esse método é um teste e deve ser executado".
    @Test
    void deveCriarPostComSucesso() {

        // ---------------------------------------------------------
        // CORPO (BODY) DA REQUISIÇÃO
        // ---------------------------------------------------------
        // Aqui criamos o corpo da requisição em formato JSON.
        // Usamos um Text Block do Java (""" """), que facilita
        // escrever JSON diretamente, sem muitas aspas.
        //
        // Esse JSON é o conteúdo que será enviado no POST.
        String body = """
            {
              "title": "Teste API",
              "body": "Criando post via RestAssured",
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
                // Esse body será enviado no POST.
                .body(body)

                // -------------------------------------------------
                // when()
                // -------------------------------------------------
                // Indica a ação que será executada.
                // "when" significa: "Quando eu fizer algo..."
                .when()

                // Executa uma requisição HTTP do tipo POST.
                // O endpoint chamado é /posts.
                .post("/posts")

                // -------------------------------------------------
                // then()
                // -------------------------------------------------
                // Aqui começam as validações.
                // "then" significa: "Então o resultado esperado é..."
                .then()

                // Valida que a API respondeu com status HTTP 201.
                // 201 significa "Created" (criado com sucesso).
                .statusCode(201)

                // Valida que o campo "title" retornado no JSON
                // é exatamente igual ao enviado.
                .body("title", equalTo("Teste API"))

                // Valida que o campo "body" retornado no JSON
                // é exatamente igual ao enviado.
                .body("body", equalTo("Criando post via RestAssured"))

                // Valida que o campo "userId" retornado no JSON
                // é igual a 1.
                .body("userId", equalTo(1))

                // Valida que o campo "id" foi gerado pela API
                // e não é nulo.
                .body("id", notNullValue());
    }
}
