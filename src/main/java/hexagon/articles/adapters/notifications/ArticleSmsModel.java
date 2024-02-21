package hexagon.articles.adapters.notifications;

import hexagon.articles.domain.model.Article;

class ArticleSmsModel {
    private static final String CONTENT = "Please check your email. We have sent you publication details of the article: >>%s<<";
    private final String recipientId;
    private final String text;

    private ArticleSmsModel(final String recipientId, final String text) {
        this.recipientId = recipientId;
        this.text = text;
    }

    public static ArticleSmsModel of(final Article article) {
        return new ArticleSmsModel(
                article.author().name().value(),
                String.format(CONTENT, article.title().value()));
    }

    @Override
    public String toString() {
        return text;
    }
}
