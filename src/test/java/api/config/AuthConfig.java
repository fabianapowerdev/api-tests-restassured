// Define o pacote onde essa classe está.
// Aqui ficam as classes de CONFIGURAÇÃO do projeto.
package api.config;

// Classe responsável apenas por AUTENTICAÇÃO.
// Ela decide qual token será usado nos testes.
public class AuthConfig {

    // ---------------------------------------------------------
    // MÉTODO QUE DEVOLVE O TOKEN DE AUTENTICAÇÃO
    // ---------------------------------------------------------
    // Todos os testes chamam ESSE método quando precisam de token.
    // Nenhum teste precisa saber de onde esse token vem.
    public static String getToken() {

        // Lê um valor passado por parâmetro na execução do Maven.
        // Exemplo:
        // mvn clean test -Dtoken=meu_token_real
        String token = System.getProperty("token");

        // Verifica se o token NÃO foi informado ou está vazio
        if (token == null || token.isBlank()) {

            // -------------------------------------------------
            // TOKEN MOCK (FAKE) PARA ESTUDO
            // -------------------------------------------------
            // Aqui usamos um token fixo apenas para estudo.
            // Ele NÃO vem de login real.
            //
            // Em projeto real:
            // - aqui chamaria um AuthService
            // - faria login na API
            // - receberia um token válido
            //
            // Para estudo, isso simula a autenticação.
            return "Bearer TOKEN_DE_ESTUDO";
        }

        // -------------------------------------------------
        // TOKEN INFORMADO VIA PARÂMETRO
        // -------------------------------------------------
        // Se o token foi passado, adicionamos o prefixo "Bearer".
        // Esse formato é o padrão de autenticação em APIs REST.
        return "Bearer " + token;
    }
}
