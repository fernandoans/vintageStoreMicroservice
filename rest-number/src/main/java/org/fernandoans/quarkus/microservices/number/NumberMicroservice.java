package org.fernandoans.quarkus.microservices.number;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    info = @Info(
        title = "Number Microservice com Quarkus",
        description = "Gerar os números dos ISBN",
        version = "1.0",
        contact = @Contact(name = "@fernandoans", url = "https://twitter.com")),
    externalDocs = @ExternalDocumentation(url = "https://github.com/fernandoans", description = "Baixe o código aqui"),
    tags = {
        @Tag(name = "api", description = "Public API"),
        @Tag(name = "numbers", description = "Interessado para números")
    }
)
public class NumberMicroservice extends Application {
}
