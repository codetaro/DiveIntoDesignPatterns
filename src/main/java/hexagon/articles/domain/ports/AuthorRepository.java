package hexagon.articles.domain.ports;

import hexagon.articles.domain.model.Author;
import hexagon.articles.domain.model.AuthorId;

public interface AuthorRepository {

    Author get(AuthorId authorId);
}
