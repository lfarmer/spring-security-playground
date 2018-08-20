package uk.co.leafdevelopment.beercatalog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uk.co.leafdevelopment.beercatalog.domain.Beer;

@RepositoryRestResource
public interface BeerRepository extends CrudRepository<Beer, Long> {
}
