package hexagon.articles.domain.ports;

import hexagon.articles.domain.model.Article;

public interface AuthorNotifier {
    void notifyAboutCreationOf(Article article);
}
