package catalog;

import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookResource {

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
  public Set<Book> list() {
    return Set.of(
        new Book("kafj-83k1", "Distributed Services with Go", "Travis Jeffery"),
        new Book("3ksi-91i3", "Designing Data-Intesive Applications", "Kleppmann"));
  }
}
