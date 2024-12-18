package org.fernandoans.quarkus.microservices.number;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    info = @Info(title = "Number API", version = "1.0"),
    externalDocs = @ExternalDocumentation(url = "https://github.com/fernandoans", description = "Baixe o código aqui"),
    tags = {
        @Tag(name = "api", description = "Public API"),
        @Tag(name = "numbers", description = "Interessado para números")
    }
)
public class NumberMicroservice extends Application {
}
