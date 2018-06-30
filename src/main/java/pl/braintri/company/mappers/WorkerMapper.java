package pl.braintri.company.mappers;

import pl.braintri.company.domain.entities.Worker;
import pl.braintri.company.dtos.WorkerDto;

public class WorkerMapper {
    PositionMapper positionMapper = new PositionMapper();

    public WorkerDto dbToDto(Worker worker){
        if(worker == null){
            return new WorkerDto();
        }
        WorkerDto workerDto = new WorkerDto();
        workerDto.setId(worker.getId());
        workerDto.setEmail(worker.getEmail());
        workerDto.setFirstName(worker.getFirstName());
        workerDto.setLastName(worker.getLastName());
        workerDto.setOtherName(worker.getOtherName());
        workerDto.setPosition(positionMapper.dboToDto(worker.getPosition()));
        workerDto.setSalary(worker.getSalary());
        return workerDto;
    }

    public Worker dtoToDb(WorkerDto workerDto){
        if(workerDto == null){
            return new Worker();
        }
        Worker worker = new Worker();
        worker.setId(workerDto.getId());
        worker.setEmail(workerDto.getEmail());
        worker.setFirstName(workerDto.getFirstName());
        worker.setLastName(workerDto.getLastName());
        worker.setOtherName(workerDto.getOtherName());
        worker.setPosition(positionMapper.dtoToDb(workerDto.getPosition()));
        worker.setSalary(workerDto.getSalary());
        return worker;
    }
}
