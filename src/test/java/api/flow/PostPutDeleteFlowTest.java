// Define o pacote onde essa classe está localizada.
// Aqui ficam os testes de FLUXO, ou seja,
// testes que executam várias operações em sequência.
package api.flow;

// Importa o BaseTest para herdar toda a configuração comum:
// - URL base
// - Headers
// - Token de autenticação
// - SSL liberado
// - Logs automáticos em caso de erro
import api.base.BaseTest;

// Importa a classe responsável por montar os dados (payload) do post.
// Ela cria o corpo da requisição para POST e PUT.
import api.payload.PostPayload;

// Importa o Service que sabe executar as chamadas HTTP.
// Ele contém métodos como createPost, updatePost e deletePost.
import api.service.PostService;

// Importa a classe Response do RestAssured.
// Ela representa a resposta da API (status, body, headers, etc).
import io.restassured.response.Response;

// Importa a anotação @Test do JUnit.
// Indica que o método abaixo é um teste automatizado.
import org.junit.jupiter.api.Test;


// Classe de teste responsável por validar
// um FLUXO COMPLETO: POST → PUT → DELETE.
public class PostPutDeleteFlowTest extends BaseTest {

    // Anotação que marca este método como teste.
    @Test
    void deveExecutarFluxoPostPutDeleteComSucesso() {

        // ---------------------------------------------------------
        // 1️⃣ CRIA O SERVICE
        // ---------------------------------------------------------
        // Aqui criamos o PostService usando o `spec`
        // que vem do BaseTest.
        //
        // Isso garante que o service já tem:
        // - baseUri
        // - headers
        // - token
        PostService postService = new PostService(spec);

        // =========================================================
        // POST - CRIA O RECURSO
        // =========================================================
        // Executa o POST para criar um novo post na API.
        // Valida se o status retornado é 201 (Created).
        //
        // Depois disso, extraímos a resposta para poder
        // acessar os dados do JSON retornado.
        Response postResponse =
                postService.createPost(PostPayload.create())
                        .then()
                        .statusCode(201)
                        .extract()
                        .response();

        // ---------------------------------------------------------
        // LÊ O ID RETORNADO NO JSON
        // ---------------------------------------------------------
        // Aqui pegamos o campo "id" retornado pela API
        // e guardamos em uma variável.
        int createdId = postResponse.jsonPath().getInt("id");

        // Apenas para visualização no console,
        // mostramos o id criado.
        // (No JSONPlaceholder esse id é apenas um mock.)
        System.out.println("ID criado (mock): " + createdId);

        // =========================================================
        // IMPORTANTE ⚠️
        // =========================================================
        // A API JSONPlaceholder é apenas um MOCK.
        // Ela NÃO mantém estado real dos dados.
        //
        // Isso significa que:
        // - o ID criado no POST não pode ser usado
        //   de forma dinâmica no PUT e DELETE.
        //
        // Por isso, usamos um ID fixo para simular o fluxo.
        int fixedId = 1;

        // =========================================================
        // PUT - ATUALIZA O RECURSO
        // =========================================================
        // Executa o PUT usando um ID fixo.
        // Atualiza os dados do post.
        // Valida se o status retornado é 200 (OK).
        postService.updatePost(fixedId, PostPayload.update(fixedId))
                .then()
                .statusCode(200);

        // =========================================================
        // DELETE - REMOVE O RECURSO
        // =========================================================
        // Executa o DELETE usando o mesmo ID fixo.
        // Valida se a API respondeu com sucesso (status 200).
        postService.deletePost(fixedId)
                .then()
                .statusCode(200);
    }
}
