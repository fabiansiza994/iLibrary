package com.library.fmsp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(
            contact = @Contact(
            name = "Fabian dev",
            email = "Fabiansiza994@gmail.com",
            url = "https://github.com/fabiansiza994/iLibrary"
            ),
            description = "OpenApi Documentation for User mehtods in a Spring Project",
            title = "Register users",
            version = "1.0",
            license = @License(
                    name = "Licence Dev",
                    url = "https://fmsp-url.com"
            ),
            termsOfService = "Terms of service"
        ),
        servers = @Server(description = "Local ENV", url = "http://localhost:8081"),
        security = {
        @SecurityRequirement(name = "bearerAuth")
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
