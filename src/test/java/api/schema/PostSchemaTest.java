// Define o pacote onde essa classe está localizada.
// Aqui ficam os testes relacionados a SCHEMA / CONTRATO da API.
package api.schema;

// Importa o BaseTest para herdar toda a configuração comum:
// - URL base da API
// - Headers padrão (Content-Type, Authorization)
// - Token de autenticação
// - Configuração de SSL
// - Logs automáticos em caso de erro
import api.base.BaseTest;

// Importa a classe responsável por montar os dados (payload) do post.
// Ela cria o corpo da requisição que será enviado no POST.
import api.payload.PostPayload;

// Importa o Service que sabe executar chamadas HTTP.
// Ele contém métodos como createPost.
import api.service.PostService;

// Importa a anotação @Test do JUnit,
// indicando que o método abaixo é um teste automatizado.
import org.junit.jupiter.api.Test;

// Importa o validador de JSON Schema do RestAssured.
// Esse método compara a resposta da API com um arquivo de schema (.json).
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


// Classe de teste responsável por validar o CONTRATO da resposta do POST.
// Ela herda BaseTest, então já vem com toda a infra pronta.
public class PostSchemaTest extends BaseTest {

    // Anotação que diz ao JUnit:
    // "Esse método é um teste e deve ser executado".
    @Test
    void deveValidarSchemaDoPostComSucesso() {

        // ---------------------------------------------------------
        // CRIA O SERVICE
        // ---------------------------------------------------------
        // Aqui instanciamos o PostService usando o `spec` do BaseTest.
        //
        // Isso garante que todas as configurações já estão aplicadas:
        // - baseUri
        // - headers
        // - token
        PostService postService = new PostService(spec);

        // ---------------------------------------------------------
        // EXECUTA O POST + VALIDA O SCHEMA
        // ---------------------------------------------------------
        // Aqui fazemos três coisas em sequência:
        //
        // 1️⃣ Executamos o POST para criar um post
        // 2️⃣ Validamos se a API respondeu com status 201 (Created)
        // 3️⃣ Validamos se o corpo da resposta segue o contrato esperado
        //
        // IMPORTANTE:
        // Esse teste NÃO valida valores específicos.
        // Ele valida apenas a ESTRUTURA da resposta.
        postService.createPost(PostPayload.create())
                .then()

                // Valida que a API retornou HTTP 201 (criação com sucesso).
                .statusCode(201)

                // Valida se o JSON retornado pela API
                // segue exatamente o schema definido no arquivo:
                //
                // src/test/resources/schemas/post-schema.json
                //
                // Se faltar campo, mudar tipo ou quebrar o contrato,
                // esse teste vai falhar.
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }
}