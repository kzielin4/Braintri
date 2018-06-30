package pl.braintri.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.braintri.company.domain.entities.Worker;
import pl.braintri.company.mappers.WorkerMapper;
import pl.braintri.company.services.WorkerService;

@RestController
@RequestMapping("workers")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    private WorkerMapper workerMapper = new WorkerMapper();


    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Worker getWorker(@PathVariable() Long id){
        return workerService.getWorker(id);
    }

    @RequestMapping("/")
    public String lol(){
        return "lol";
    }
}
