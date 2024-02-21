package hexagon.articles.domain.ports;

import hexagon.articles.domain.model.Article;

public interface SocialMediaPublisher {
    void publish(Article article);
}
