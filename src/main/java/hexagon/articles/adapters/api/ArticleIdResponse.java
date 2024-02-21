package hexagon.articles.adapters.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import hexagon.articles.domain.model.ArticleId;

class ArticleIdResponse {
    private final String id;

    private ArticleIdResponse(final String id) {
        this.id = id;
    }

    static ArticleIdResponse of(final ArticleId articleId) {
        return new ArticleIdResponse(articleId.value());
    }

    // When serialize the Java object to JSON, the field names in the JSON output will be "id"
    @JsonProperty("id")
    String id() {
        return id;
    }
}
