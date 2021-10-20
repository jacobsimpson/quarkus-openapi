package catalog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.openapi.example.api.BooksApiService;

@ApplicationScoped
public class Producer {

  @Produces
  BooksApiService booksApiService() {
    return new BookResource();
  }
}
