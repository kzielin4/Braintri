package pl.braintri.company.mappers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.braintri.company.domain.entities.Position;
import pl.braintri.company.dtos.PositionDto;

public class PositionMapper {

    public PositionDto dboToDto(Position position){
        if (position == null) {
            return  new PositionDto();
        }
        PositionDto positionDto = new PositionDto();
        positionDto.setId(position.getId());
        positionDto.setName(position.getName());
        positionDto.setAmmountOfAssignedWorkers(Long.valueOf(position.getWorkers().size()));
        return  positionDto;

    }

    public Position dtoToDb(PositionDto positionDto){
        if (positionDto == null) {
            return  new Position();
        }
        Position position = new Position();
        position.setId(positionDto.getId());
        position.setName(positionDto.getName());
        return  position;
    }
}
