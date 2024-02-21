package hexagon.articles.adapters.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import hexagon.articles.domain.model.AuthorId;
import hexagon.articles.domain.model.Content;
import hexagon.articles.domain.model.Title;

class ArticleRequest {
    private final String title;
    private final String content;
    private final String authorId;

    // When deserialize the JSON input to an object, the values of the properties will be mapped to the fields of the object using the annotated constructor
    ArticleRequest(@JsonProperty("title") final String title, @JsonProperty("content") final String content, @JsonProperty("authorId") final String authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    Title title() {
        return Title.of(title);
    }

    Content content() {
        return Content.of(content);
    }

    AuthorId authorId() {
        return AuthorId.of(authorId);
    }
}
