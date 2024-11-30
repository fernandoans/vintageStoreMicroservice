#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.fernandoans.quarkus.microservices \
        -DprojectArtifactId=rest-book \
        -DclassName="org.fernandoans.quarkus.microservices.book.BookResource" \
        -Dpath="/api/books" \
        -Dextensions="resteasy-jsonb, smallrye-openapi"
