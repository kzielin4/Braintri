package pl.braintri.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.braintri.company.domain.entities.Position;
import pl.braintri.company.domain.entities.Worker;
import pl.braintri.company.domain.repositories.PositionRepository;
import pl.braintri.company.domain.repositories.WorkerRepository;
import pl.braintri.company.dtos.PositionDto;
import pl.braintri.company.mappers.PositionMapper;
import pl.braintri.company.mappers.WorkerMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionService {
    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;
    PositionMapper positionMapper = new PositionMapper();

    @Autowired
    public PositionService(WorkerRepository workerRepository, PositionRepository positionRepository) {
        this.workerRepository = workerRepository;
        this.positionRepository = positionRepository;
    }

    public List<PositionDto> getAllPositionsDto(){
        List<PositionDto> positionDtoList = new ArrayList<>();
        for(Position position : getAllPositions()){
            positionDtoList.add(positionMapper.dboToDto(position));
        }
        return positionDtoList;
    }

    @Transactional
    public List<Position> getAllPositions(){
        List<Position> positionList = new ArrayList<>();
        positionRepository.findAll().forEach(positionList::add);
        return positionList;
    }
}
