// Define o pacote onde essa classe está localizada.
// Aqui ficam os testes relacionados ao método GET,
// ou seja, testes de consulta/busca de dados.
package api.get;

// Importa o BaseTest para herdar toda a configuração comum:
// - URL base da API
// - Headers padrão
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
// Eles ajudam a validar valores retornados pela API.
import static org.hamcrest.Matchers.*;


// Classe de teste responsável por validar
// a busca de um usuário (GET).
public class GetUserTest extends BaseTest {

    // Anotação que diz ao JUnit:
    // "Esse método é um teste e deve ser executado".
    @Test
    void deveBuscarUsuarioComSucesso() {

        // ---------------------------------------------------------
        // given()
        // ---------------------------------------------------------
        // Aqui começamos a montar a requisição HTTP.
        // "given" significa: "Dado que tenho essa configuração..."
        given()

                // Aplica a especificação padrão criada no BaseTest.
                // Isso inclui:
                // - baseUri
                // - headers (Content-Type, Authorization)
                // - token
                .spec(spec)

                // -------------------------------------------------
                // when()
                // -------------------------------------------------
                // Aqui informamos a ação que será executada.
                // "when" significa: "Quando eu fizer algo..."
                .when()

                // Executa uma requisição HTTP do tipo GET.
                // O endpoint chamado é /users/1,
                // ou seja, busca o usuário com ID 1.
                .get("/users/1")

                // -------------------------------------------------
                // then()
                // -------------------------------------------------
                // Aqui começam as validações do resultado.
                // "then" significa: "Então o resultado esperado é..."
                .then()

                // Valida que a API respondeu com status HTTP 200.
                // 200 significa: requisição realizada com sucesso.
                .statusCode(200)

                // Valida que o campo "id" do JSON retornado é igual a 1.
                // Isso garante que estamos recebendo o usuário correto.
                .body("id", equalTo(1))

                // Valida que o campo "username" existe
                // e não está vazio (não é null).
                .body("username", notNullValue());
    }
}