package hexagon.articles.domain.ports;

import hexagon.articles.domain.model.Article;

public interface ArticleMessageSender {
    void sendMessageForCreated(Article article);
    void sendMessageForRetrieved(Article article);
}
