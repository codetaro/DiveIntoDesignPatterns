package hexagon.articles.adapters.messagebroker;

import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.ports.ArticleMessageSender;
import org.springframework.stereotype.Component;

@Component
class MessageBrokerArticleMessageSender implements ArticleMessageSender {
    @Override
    public void sendMessageForCreated(Article article) {
        ArticleCreatedMessage.of(article);
    }

    @Override
    public void sendMessageForRetrieved(Article article) {
        ArticleRetrievedMessage.of(article);
    }
}
