package org.fernandoans.quarkus.microservices.book;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Getter
@Setter
@ToString
@Schema(description = "Um Livro")
public class Book {

    @Schema(required = true)
    @JsonbProperty("isbn_13")
    private String isbn13;
    @Schema(required = true)
    private String titulo;
    private String autor;
    @JsonbProperty("ano_publicacao")
    private int anoPublicacao;
    public String genero;
    @Schema(implementation = String.class, format = "date")
    @JsonbDateFormat("dd/MM/yyyy")
    @JsonbProperty("data_criacao")
    public Instant dataCriacao;

    public Book() {
        this.dataCriacao = Instant.now();
    }
}
