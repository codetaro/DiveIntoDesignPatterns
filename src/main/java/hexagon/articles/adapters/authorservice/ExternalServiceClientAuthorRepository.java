package hexagon.articles.adapters.authorservice;

import hexagon.articles.domain.model.Author;
import hexagon.articles.domain.model.AuthorId;
import hexagon.articles.domain.ports.AuthorRepository;
import org.springframework.stereotype.Component;

import static hexagon.articles.adapters.authorservice.AuthorExternalModel.authorExternalModel;

@Component
public class ExternalServiceClientAuthorRepository implements AuthorRepository {
    @Override
    public Author get(final AuthorId authorId) {
        final AuthorExternalModel author = authorExternalModel()
                .withId(928467)
                .withFirstName("William")
                .withLastName("Shakespeare")
                .build();
        return author.toDomain();
    }
}
