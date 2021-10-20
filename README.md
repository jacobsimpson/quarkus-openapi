# catalog Project

A simple project for a Quarkus REST server that supports API first.

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
