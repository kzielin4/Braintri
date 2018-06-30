package pl.braintri.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.braintri.company.domain.entities.Worker;
import pl.braintri.company.domain.repositories.PositionRepository;
import pl.braintri.company.domain.repositories.WorkerRepository;
import pl.braintri.company.dtos.WorkerDto;
import pl.braintri.company.mappers.WorkerMapper;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private WorkerMapper workerMapper = new WorkerMapper();


    @Autowired
    public WorkerService(WorkerRepository workerRepository, PositionRepository positionRepository) {
        this.workerRepository = workerRepository;
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
    public Worker getWorker(Long id){
        return workerRepository.getById(id);
    }


    public List<WorkerDto> getAllWorkersDto(){
        List<WorkerDto> WorkerDtoList = new ArrayList<>();
        for(Worker position : getAllWorkers()){
            WorkerDtoList.add(workerMapper.dbToDto(position));
        }
        return WorkerDtoList;
    }

    @Transactional
    public List<Worker> getAllWorkers(){
        List<Worker> workerList = new ArrayList<>();
        workerRepository.findAll().forEach(workerList::add);
        return workerList;
    }
    
    public WorkerRepository getWorkerRepository() {
        return workerRepository;
    }

}
