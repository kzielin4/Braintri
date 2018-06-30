package pl.braintri.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.braintri.company.domain.entities.Position;
import pl.braintri.company.dtos.PositionDto;
import pl.braintri.company.mappers.PositionMapper;
import pl.braintri.company.services.PositionService;

import java.util.List;

@RestController
@RequestMapping("positions")
public class PositionController {

    @Autowired
    PositionService positionService;

    public PositionController() {
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<PositionDto> getAll(){
        return positionService.getAllPositionsDto();
    }

    public PositionService getPositionService() {
        return positionService;
    }

    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}
