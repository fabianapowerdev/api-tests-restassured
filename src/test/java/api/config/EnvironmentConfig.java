package api.config;

public class EnvironmentConfig {

    public static String getBaseUrl() {

        // Lê o ambiente passado por parâmetro
        String env = System.getProperty("env", "dev");

        return switch (env.toLowerCase()) {
            case "hml" -> "https://api-hml.seuprojeto.com";
            case "qa"  -> "https://api-qa.seuprojeto.com";
            default    -> "https://jsonplaceholder.typicode.com";
        };
    }
}
