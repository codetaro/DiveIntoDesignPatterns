package hexagon.articles.adapters.notifications;

import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.ports.AuthorNotifier;
import org.springframework.stereotype.Component;

@Component
class AuthorMailNotifier implements AuthorNotifier {
    @Override
    public void notifyAboutCreationOf(final Article article) {
        ArticleMailModel.of(article);
    }
}
