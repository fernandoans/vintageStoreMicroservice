package org.fernandoans.quarkus.microservices.book;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    info = @Info(title = "Book API", version = "1.0"),
    externalDocs = @ExternalDocumentation(url = "https://github.com/fernandoans", description = "Baixe o código aqui"),
    tags = {
        @Tag(name = "api", description = "Public API"),
        @Tag(name = "books", description = "Interessado para livros")
    }
)
public class BookMicroservice extends Application {
}
