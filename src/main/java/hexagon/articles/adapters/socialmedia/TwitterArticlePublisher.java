package hexagon.articles.adapters.socialmedia;

import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.ports.SocialMediaPublisher;

class TwitterArticlePublisher implements SocialMediaPublisher {
    private final TwitterClient twitterClient;

    TwitterArticlePublisher(final TwitterClient twitterClient) {
        this.twitterClient = twitterClient;
    }

    @Override
    public void publish(Article article) {
        final ArticleTwitterModel articleTwitter = ArticleTwitterModel.of(article);
        twitterClient.tweet(articleTwitter);
    }
}
