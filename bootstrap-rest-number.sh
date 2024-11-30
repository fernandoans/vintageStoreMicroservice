#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.fernandoans.quarkus.microservices \
        -DprojectArtifactId=rest-number \
        -DclassName="org.agoncal.fernandoans.microservices.number.NumberResource" \
        -Dpath="/api/numbers" \
        -Dextensions="resteasy-jsonb, smallrye-openapi"
