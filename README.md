# catalog Project

A simple project for a Quarkus REST server that supports API first.

Starting from an OpenAPI specification that describes the API, this project
uses the `openApiGenerate` gradle task to generate some source code that
represents the implementation of the API.

Since there is no native adaptor for Quarkus, this build uses some [custom
templates](https://github.com/jacobsimpson/quarkus-openapi/tree/main/src/main/templates),
and specific `openApiGenerate` task configuration to generate the appropriate
source code for Quarkus.

## How it was built

```
mvn io.quarkus.platform:quarkus-maven-plugin:2.3.0.Final:create \
    -DprojectGroupId=app \
    -DprojectArtifactId=catalog \
    -DprojectVersion=v1 \
    -DclassName="catalog.BookResource" \
    -Dextensions="resteasy,resteasy-jackson" \
    -DbuildTool=gradle
```

## How to exercise code generation

```
./gradlew clean openApiGenerate build spotlessApply check test >& debug
find build/generated-src -type f
```

## How to test the service

```
curl -v -H "Content-Type: application/json" http://127.0.0.1:8080/books | jq "."
```
