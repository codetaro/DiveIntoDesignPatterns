package hexagon.articles.domain.ports;

import hexagon.articles.domain.ArticlePublisher;
import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.model.ArticleId;
import hexagon.articles.domain.model.Author;
import hexagon.articles.domain.model.AuthorId;
import hexagon.articles.domain.model.Content;
import hexagon.articles.domain.model.Title;

public final class ArticleService {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final ArticlePublisher eventPublisher;

    public ArticleService(final ArticleRepository articleRepository,
                          final AuthorRepository authorRepository,
                          final ArticlePublisher eventPublisher) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.eventPublisher = eventPublisher;
    }

    // domain operations implemented in ArticleService, creating and retrieving an article,
    // depend on external dependencies hidden behind port interfaces
    public ArticleId create(final AuthorId authorId, final Title title, final Content content) {
        final Author author = authorRepository.get(authorId);
        final Article article = articleRepository.save(author, title, content);

        article.validateEligibilityForPublication();

        eventPublisher.publishCreationOf(article);
        return article.id();
    }

    public Article get(final ArticleId id) {
        final Article article = articleRepository.get(id);
        eventPublisher.publishRetrievalOf(article);
        return article;
    }
}
