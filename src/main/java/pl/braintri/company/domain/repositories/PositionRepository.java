package pl.braintri.company.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.braintri.company.domain.entities.Position;

public interface PositionRepository extends CrudRepository<Position, Long>{
}
