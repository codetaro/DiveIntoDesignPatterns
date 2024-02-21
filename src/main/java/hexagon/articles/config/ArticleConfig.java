package hexagon.articles.config;

import hexagon.articles.domain.ArticlePublisher;
import hexagon.articles.domain.ports.ArticleMessageSender;
import hexagon.articles.domain.ports.ArticleRepository;
import hexagon.articles.domain.ports.ArticleService;
import hexagon.articles.domain.ports.AuthorNotifier;
import hexagon.articles.domain.ports.AuthorRepository;
import hexagon.articles.domain.ports.SocialMediaPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class ArticleConfig {

    @Bean
    ArticlePublisher articleEventPublisher(final ArticleMessageSender eventPublisher,
                                           final List<SocialMediaPublisher> socialMediaPublishers,
                                           final List<AuthorNotifier> articleAuthorNotifiers) {
        return new ArticlePublisher(eventPublisher, socialMediaPublishers, articleAuthorNotifiers);
    }

    @Bean
    ArticleService articleService(final ArticleRepository articleRepository,
                                  final AuthorRepository authorRepository,
                                  final ArticlePublisher articleEventPublisher) {
        return new ArticleService(articleRepository, authorRepository, articleEventPublisher);
    }
}
