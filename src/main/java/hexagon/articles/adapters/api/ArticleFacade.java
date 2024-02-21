package hexagon.articles.adapters.api;

import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.model.ArticleId;
import hexagon.articles.domain.ports.ArticleService;
import org.springframework.stereotype.Component;

@Component
// Introduce ArticleFacade due to the fact that orchestration logic and
// domain model translation should not be the responsibility of the controller
class ArticleFacade {
    private final ArticleService articleService;

    ArticleFacade(final ArticleService articleService) {
        this.articleService = articleService;
    }

    ArticleResponse get(final String articleId) {
        final Article article = articleService.get(ArticleId.of(articleId));
        return ArticleResponse.of(article); // translate domain model to API model
    }

    ArticleIdResponse create(final ArticleRequest articleRequest) {
        final ArticleId articleId = articleService.create(articleRequest.authorId(), articleRequest.title(), articleRequest.content());
        return ArticleIdResponse.of(articleId);
    }
}
