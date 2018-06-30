package pl.braintri.company.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.braintri.company.domain.entities.Worker;

@Transactional
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker getById(Long id);
}
