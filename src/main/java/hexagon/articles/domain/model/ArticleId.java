package hexagon.articles.domain.model;

public class ArticleId {
    private final String value;

    // final means that inside the method the variables can not be reassigned
    private ArticleId(final String value) {
        this.value = value;
    }

    public static ArticleId of(final String articleId) {
        return new ArticleId(articleId);
    }

    public String value() {
        return value;
    }
}
