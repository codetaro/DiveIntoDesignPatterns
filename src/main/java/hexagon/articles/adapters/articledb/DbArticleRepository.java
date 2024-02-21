package hexagon.articles.adapters.articledb;

import hexagon.articles.domain.model.Article;
import hexagon.articles.domain.model.ArticleId;
import hexagon.articles.domain.model.Author;
import hexagon.articles.domain.model.Content;
import hexagon.articles.domain.model.Title;
import hexagon.articles.domain.ports.ArticleRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static hexagon.articles.adapters.articledb.ArticleDatabaseModel.articleDatabaseModel;
import static hexagon.articles.adapters.articledb.ArticleDatabaseModel.of;

@Component
class DbArticleRepository implements ArticleRepository {
    @Override
    public Article save(final Author author, final Title title, final Content content) {
        final ArticleDatabaseModel entity = of(author, title, content);
        // entity 一般情况下此结构与数据库结构一一对应，作为程序与数据库的映射桥梁
        // domain 即领域模型，银行、保险、电商、物流、医疗、DDD 领域驱动设计
        return entity.toDomain();
    }

    @Override
    public Article get(ArticleId id) {
        final ArticleDatabaseModel entity = articleDatabaseModel()
                .withId(UUID.fromString(id.value()))
                .withAuthorName("William Shakespeare")
                .withAuthorId("928467")
                .withTitle("Hexagonal Architecture")
                .withContent("Lorem ipsum")
                .build();
        return entity.toDomain();
    }
}
