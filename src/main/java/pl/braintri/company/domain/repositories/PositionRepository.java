package pl.braintri.company.domain.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import pl.braintri.company.domain.entities.Position;

public interface PositionRepository extends CrudRepository<Position, Long>, QueryDslPredicateExecutor<Position> {
}
