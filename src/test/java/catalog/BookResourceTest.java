package catalog;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import java.util.List;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BookResourceTest {

  @Test
  public void testHelloEndpoint() throws JsonProcessingException {
    var want =
        new ObjectMapper()
            .writeValueAsString(
                List.of(
                    new BookResource.Book(
                        "kafj-83k1", "Distributed Services with Go", "Travis Jeffery"),
                    new BookResource.Book(
                        "3ksi-91i3", "Designing Data-Intesive Applications", "Kleppmann")));

    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/books")
        .then()
        .statusCode(200)
        .body(is(want));
  }
}
