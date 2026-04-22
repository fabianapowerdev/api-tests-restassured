package api.base;

import api.config.AuthConfig;
import api.config.EnvironmentConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class BaseTest {

    protected static RequestSpecification spec;

    @BeforeAll
    static void setup() {

        // Ignora certificados SSL (ESSENCIAL para ambiente Windows/corporativo)
        useRelaxedHTTPSValidation();


        spec = new RequestSpecBuilder()
                .setBaseUri(EnvironmentConfig.getBaseUrl())
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", AuthConfig.getToken())
                .build();


        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}

