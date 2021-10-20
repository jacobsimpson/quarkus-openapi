package catalog;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.openapi.example.api.BooksApiService;

@Path("/books")
public class BookResource implements BooksApiService {

  public static class Book {
    public String id;
    public String title;
    public String author;

    public Book(String id, String title, String author) {
      this.id = id;
      this.title = title;
      this.author = author;
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response listBooks(Integer limit, SecurityContext securityContext) {
    return Response.ok(
            List.of(
                new Book("kafj-83k1", "Distributed Services with Go", "Travis Jeffery"),
                new Book("3ksi-91i3", "Designing Data-Intesive Applications", "Kleppmann")),
            MediaType.APPLICATION_JSON)
        .build();
  }
}
