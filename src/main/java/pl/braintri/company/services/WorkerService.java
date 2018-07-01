package pl.braintri.company.services;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.braintri.company.domain.criteria.SearchCriteria;
import pl.braintri.company.domain.criteria.WorkerPredicatesBuilder;
import pl.braintri.company.domain.entities.QWorker;
import pl.braintri.company.domain.entities.Worker;
import pl.braintri.company.domain.repositories.WorkerRepository;
import pl.braintri.company.dtos.WorkerDto;
import pl.braintri.company.mappers.WorkerMapper;


import javax.persistence.EntityManager;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class WorkerService {


    private final WorkerRepository workerRepository;
    private EntityManager entityManager;
    private WorkerMapper workerMapper = new WorkerMapper();

    @Autowired
    public WorkerService(WorkerRepository workerRepository, EntityManager entityManager) {
        this.workerRepository = workerRepository;
        this.entityManager = entityManager;
    }

    @Transactional(propagation = REQUIRES_NEW)
    public void saveWorker(Worker worker) {
        workerRepository.save(worker);
    }

    @Transactional
    public void deleteWorker(Long id) {
        workerRepository.delete(id);
    }


    @Transactional
    public Worker getWorker(Long id) {
        return workerRepository.getById(id);
    }

    @Transactional
    public List<WorkerDto> getAllWorkersDto(SearchCriteria searchCriteria) {
        List<WorkerDto> WorkerDtoList = new ArrayList<>();
        if (searchCriteria == null) {
            for (Worker position :  workerRepository.findAll()) {
                WorkerDtoList.add(workerMapper.dbToDto(position));
            }
        } else {
            WorkerPredicatesBuilder builder = new WorkerPredicatesBuilder().with(searchCriteria);

            for (Worker position : workerRepository.findAll(builder.build())) {
                WorkerDtoList.add(workerMapper.dbToDto(position));
            }
        }
        return WorkerDtoList;
    }


    public WorkerRepository getWorkerRepository() {
        return workerRepository;
    }

    public Long saveWorkerDto(WorkerDto workerDto) throws ValidationException {
        Worker worker = workerMapper.dtoToDb(workerDto);
        if (worker.getId() != null) {
            throw new ValidationException("Id must be null");
        }
        saveWorker(worker);
        return worker.getId();
    }
}

