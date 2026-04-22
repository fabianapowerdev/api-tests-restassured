// Define o pacote onde essa classe está localizada.
// Aqui ficam as classes de BASE (infraestrutura comum aos testes).
package api.base;

// Importa a classe responsável por decidir QUAL token será usado.
// O teste não sabe se é token real ou fake, isso fica abstraído aqui.
import api.config.AuthConfig;

// Importa a classe que decide QUAL ambiente será usado (DEV, HML, QA, etc.).
import api.config.EnvironmentConfig;

// Classe do RestAssured usada para montar uma configuração padrão de requisição.
import io.restassured.builder.RequestSpecBuilder;

// Interface que representa uma especificação de requisição HTTP
// (URL, headers, autenticação, etc.).
import io.restassured.specification.RequestSpecification;

// Anotação do JUnit que indica que um método deve rodar
// UMA ÚNICA VEZ antes de todos os testes.
import org.junit.jupiter.api.BeforeAll;

// Importa métodos estáticos do RestAssured para facilitar a escrita do código.
// Assim não precisamos escrever RestAssured.useRelaxedHTTPSValidation(), por exemplo.
import static io.restassured.RestAssured.*;


// Classe base que será herdada por TODOS os testes.
public class BaseTest {

    // Variável que guarda a configuração padrão da requisição.
    // - protected: testes que herdam essa classe podem acessar
    // - static: existe uma única vez para todos os testes
    protected static RequestSpecification spec;

    // Anotação que diz ao JUnit:
    // "Execute este método antes de QUALQUER teste rodar".
    @BeforeAll
    static void setup() {

        // ---------------------------------------------------------
        // IGNORA VALIDAÇÃO DE CERTIFICADO SSL
        // ---------------------------------------------------------
        // Isso evita erros de certificado HTTPS, muito comuns em:
        // - ambientes corporativos
        // - Windows
        // - VPN
        // - proxy
        //
        // Sem isso, muitas APIs nem respondem.
        useRelaxedHTTPSValidation();


        // ---------------------------------------------------------
        // CRIA A CONFIGURAÇÃO PADRÃO DA REQUISIÇÃO
        // ---------------------------------------------------------
        // Aqui estamos montando um "molde" que será usado
        // por TODAS as requisições dos testes.
        spec = new RequestSpecBuilder()

                // Define a URL base da API.
                // Exemplo: https://jsonplaceholder.typicode.com
                // O valor vem do EnvironmentConfig.
                .setBaseUri(EnvironmentConfig.getBaseUrl())

                // Define que todas as requisições usam JSON.
                // Assim não precisamos repetir esse header em cada teste.
                .addHeader("Content-Type", "application/json")

                // Adiciona o token de autenticação automaticamente.
                // O token vem do AuthConfig (pode ser fake ou real).
                // Os testes NÃO precisam saber disso.
                .addHeader("Authorization", AuthConfig.getToken())

                // Finaliza a criação da especificação da requisição.
                .build();


        // ---------------------------------------------------------
        // CONFIGURA LOG AUTOMÁTICO EM CASO DE ERRO
        // ---------------------------------------------------------
        // Se algum teste falhar:
        // - mostra no console a requisição enviada
        // - mostra a resposta recebida
        //
        // Se o teste passar, NÃO mostra nada (evita poluir o log).
        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}