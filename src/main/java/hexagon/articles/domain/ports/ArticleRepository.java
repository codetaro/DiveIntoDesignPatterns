package hexagon.articles.domain.ports;

import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.model.ArticleId;
import hexagon.articles.domain.model.Author;
import hexagon.articles.domain.model.Content;
import hexagon.articles.domain.model.Title;

public interface ArticleRepository {

    Article save(Author author, Title title, Content content);

    Article get(ArticleId id);
}
