package pl.braintri.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.braintri.company.domain.criteria.SearchCriteria;
import pl.braintri.company.domain.entities.Worker;
import pl.braintri.company.dtos.Operation;
import pl.braintri.company.dtos.WorkerDto;
import pl.braintri.company.services.WorkerService;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("workers")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Worker getWorker(@PathVariable() Long id) {
        return workerService.getWorker(id);
    }

    @RequestMapping(value = "/getAllByFilter", method = RequestMethod.GET)
    @ResponseBody
    public List<WorkerDto> getAllByFilter(@RequestParam("column") String column, @RequestParam("operator") Operation operation,
                                  @RequestParam("value") String value) {

        return workerService.getAllWorkersDto(new SearchCriteria(column, operation.toString() , value));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<WorkerDto> getAll() {
        return workerService.getAllWorkersDto(null);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> getWorker(@RequestBody WorkerDto worker) {
        try {
            workerService.saveWorkerDto(worker);
            return ResponseEntity.ok().build();
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
    }
}
