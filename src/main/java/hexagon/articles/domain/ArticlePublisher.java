package hexagon.articles.domain;

import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.ports.ArticleMessageSender;
import hexagon.articles.domain.ports.AuthorNotifier;
import hexagon.articles.domain.ports.SocialMediaPublisher;

import java.util.List;

public class ArticlePublisher {
    private final ArticleMessageSender messageSender;
    private final List<SocialMediaPublisher> socialMediaPublishers;
    private final List<AuthorNotifier> articleAuthorNotifiers;

    // It is important though, that the domain knows nothing about the DI framework you use
    public ArticlePublisher(final ArticleMessageSender messageSender,
                            final List<SocialMediaPublisher> socialMediaPublishers,
                            final List<AuthorNotifier> articleAuthorNotifiers) {
        this.messageSender = messageSender;
        this.socialMediaPublishers = socialMediaPublishers;
        this.articleAuthorNotifiers = articleAuthorNotifiers;
    }

    public void publishCreationOf(final Article article) {
        messageSender.sendMessageForCreated(article);
        socialMediaPublishers.forEach(socialMediaPublisher -> socialMediaPublisher.publish(article));
        articleAuthorNotifiers.forEach(articleAuthorNotifier -> articleAuthorNotifier.notifyAboutCreationOf(article));
    }

    public void publishRetrievalOf(final Article article) {
        messageSender.sendMessageForRetrieved(article);
    }
}
