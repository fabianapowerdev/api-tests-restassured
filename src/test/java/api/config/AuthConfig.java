package api.config;

public class AuthConfig {

    // Token fixo para estudo (EM PROJETO REAL isso vem de AuthService)
    public static String getToken() {

        String token = System.getProperty("token");

        if (token == null || token.isBlank()) {
            // token mock para estudo
            return "Bearer TOKEN_DE_ESTUDO";
        }

        return "Bearer " + token;
    }
}