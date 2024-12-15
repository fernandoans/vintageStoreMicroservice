package org.fernandoans.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
class BookResourceTest {
    @Test
    void deveCriarUmLivro() {
        given()
            .formParam("titulo", "Senhor dos Anéis, O")
            .formParam("autor", "J.R.R. Tolkien")
            .formParam("anoPublicacao", 1966)
            .formParam("genero", "Aventura Ficção")
        .when()
            .post("/api/books")
        .then()
            .statusCode(201)
            .body("isbn_13", startsWith("13-"))
            .body("titulo", is("Senhor dos Anéis, O"))
            .body("autor", is("J.R.R. Tolkien"))
            .body("ano_publicacao", is(1966))
            .body("data_criacao", endsWith("2024"));
    }

}