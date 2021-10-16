package catalog;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Set;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BookResourceTest {

  @Test
  public void testHelloEndpoint() throws JsonProcessingException {
    var want =
        new ObjectMapper()
            .writeValueAsString(
                Set.of(
                    new BookResource.Book(
                        "kafj-83k1", "Distributed Services with Go", "Travis Jeffery"),
                    new BookResource.Book(
                        "3ksi-91i3", "Designing Data-Intesive Applications", "Kleppmann")));

    given().when().get("/books").then().statusCode(200).body(is(want));
  }
}
