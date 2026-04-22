// Define o pacote onde essa classe está.
// Aqui ficam as classes de CONFIGURAÇÃO do projeto,
// ou seja, coisas que mudam conforme o ambiente.
package api.config;


// Classe responsável por decidir QUAL URL da API será usada.
// Ela centraliza a lógica de ambiente (DEV, HML, QA, etc.).
public class EnvironmentConfig {

    // ---------------------------------------------------------
    // MÉTODO QUE DEVOLVE A URL BASE DA API
    // ---------------------------------------------------------
    // TODOS os testes usam esse método para saber qual API chamar.
    public static String getBaseUrl() {

        // Lê o ambiente passado como parâmetro na execução do Maven.
        //
        // Exemplo:
        // mvn clean test -Denv=hml
        //
        // Se nenhum ambiente for informado,
        // o valor padrão será "dev".
        String env = System.getProperty("env", "dev");

        // ---------------------------------------------------------
        // ESCOLHE A URL COM BASE NO AMBIENTE
        // ---------------------------------------------------------
        // Aqui usamos um "switch" moderno do Java
        // para decidir qual URL retornar.
        return switch (env.toLowerCase()) {

            // Se o ambiente for "hml"
            // (Homologação)
            case "hml" ->
                    "https://api-hml.seuprojeto.com";

            // Se o ambiente for "qa"
            // (Quality Assurance)
            case "qa"  ->
                    "https://api-qa.seuprojeto.com";

            // Qualquer outro valor cai aqui.
            // Usamos como padrão a API pública
            // para testes e estudo.
            default    ->
                    "https://jsonplaceholder.typicode.com";
        };
    }
}