package org.fernandoans.quarkus.microservices.book;

import jakarta.inject.Inject;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;

@Path("/api/books")
@Tag(name = "REST Endpoint para Livros")
public class BookResource {

    @Inject
    @RestClient
    NumberProxy proxy;

    @Retry(delay = 3000)
    @Fallback(fallbackMethod = "fallbackOnCreatingABook")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(
        summary = "Criar um novo livro",
        description = "Responsável pela criação e adição de um novo livro"
    )
    public Response createABook(
            @FormParam("titulo") String titulo,
            @FormParam("autor") String autor,
            @FormParam("anoPublicacao") int anoPublicacao,
            @FormParam("genero") String genero
    ) {
        Book book = new Book();
        book.setIsbn13(proxy.generateIsbnNumbers().isbn13);
        book.setTitulo(titulo);
        book.setAutor(autor);
        book.setAnoPublicacao(anoPublicacao);
        book.setGenero(genero);
        return Response.status(201).entity(book).build();
    }

    public Response fallbackOnCreatingABook(
            String titulo,
            String autor,
            int anoPublicacao,
            String genero
    ) throws FileNotFoundException {
        Book book = new Book();
        book.setIsbn13("Será incluído");
        book.setTitulo(titulo);
        book.setAutor(autor);
        book.setAnoPublicacao(anoPublicacao);
        book.setGenero(genero);
        saveBookOnDisk(book);
        return Response.status(206).entity(book).build();
    }

    private void saveBookOnDisk(Book book) throws FileNotFoundException {
        String bookJson = JsonbBuilder.create().toJson(book);
        try (PrintWriter out = new PrintWriter("book-" + Instant.now().toEpochMilli() + ".json")) {
            out.println(bookJson);
        }
    }
}
