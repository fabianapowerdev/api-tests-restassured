// Define o pacote onde essa classe está localizada.// Define o você colocou classes relacionadas a BDD (passos: Dado/Quando/Então).
package api.bdd;

// Importa a BaseTest para herdar a configuração padrão da API:
// - baseUrl (EnvironmentConfig)
// - headers (Content-Type, Authorization)
// - SSL relaxado
// - logs automáticos em falha
import api.base.BaseTest;

// Importa o "molde" de dados (payload) do post.
// Ele cria os dados que serão enviados no POST.
import api.payload.PostPayload;

// Importa o Service que sabe fazer a chamada HTTP para a API.
// Ele contém o método createPost(...) e outros.
import api.service.PostService;

// Importa Response, que representa a resposta da API após uma requisição.
// Ex.: status code, body, headers, etc.
import io.restassured.response.Response;

// Importa o validador de JSON Schema.
// Isso permite validar o CONTRATO (estrutura) da resposta.
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


// Classe que contém os "passos" de um cenário BDD.
// Ela herda BaseTest para ter acesso ao `spec` (config padrão da API).
public class PostSteps extends BaseTest {

    // Essa variável vai guardar o serviço que executa o POST.
    // (Service = quem sabe "falar com a API")
    private PostService postService;

    // Essa variável vai guardar a resposta da API depois do POST.
    // (Response = resultado que a API devolveu)
    private Response response;


    // ===== DADO =====
    // "Dado" representa o estado inicial / pré-condições do cenário.
    // Em BDD, é como dizer: "antes de fazer algo, o que eu preciso ter?"

    public void dadoQuePossuoUmTokenValido() {
        // Aqui você NÃO gera token na mão.
        // O token já é colocado automaticamente pelo BaseTest/AuthConfig
        // dentro do RequestSpecification `spec`.

        // Aqui a gente só inicializa o Service usando o `spec`.
        // Assim, qualquer chamada feita por esse service já vai:
        // - com baseUri
        // - com headers
        // - com Authorization
        postService = new PostService(spec);
    }

    public void dadoQuePossuoDadosValidosParaCriarUmPost() {
        // Este passo existe para refletir o texto do Gherkin:
        // "E possuo dados válidos para criar um post"

        // Como o payload é criado no PostPayload.create(),
        // você NÃO precisa fazer nada aqui.

        // Em projetos reais, este passo poderia:
        // - preparar massa de dados
        // - carregar arquivo JSON
        // - ajustar valores conforme cenário
        // Como aqui é didático, ele fica "vazio" de propósito.
    }


    // ===== QUANDO =====
    // "Quando" é a ação principal do cenário.
    // É o momento em que você faz a requisição para a API.

    public void quandoEuEnvioARequisicaoDeCriacaoDoPost() {
        // Aqui chamamos de fato a API, via Service.
        // O payload é montado pelo PostPayload.create().
        // O resultado (response) fica guardado na variável response.
        response = postService.createPost(PostPayload.create());
    }


    // ===== ENTÃO =====
    // "Então" é a verificação (assert).
    // Aqui você valida o que a API devolveu.

    public void entaoAApiDeveRetornarStatus201() {
        // Valida o status code da resposta.
        // 201 = Created (criado com sucesso).
        response.then().statusCode(201);
    }

    public void eARespostaDeveSeguirOContratoEsperado() {
        // Valida o contrato (estrutura) da resposta usando JSON Schema.
        // Ele lê o arquivo em:
        // src/test/resources/schemas/post-schema.json
        // e compara com o JSON retornado pela API.
        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }
}
