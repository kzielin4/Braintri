package pl.braintri.company.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.braintri.company.domain.entities.Position;
import pl.braintri.company.domain.entities.Worker;
import pl.braintri.company.domain.repositories.PositionRepository;
import pl.braintri.company.domain.repositories.WorkerRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public DatabaseLoader(WorkerRepository workerRepository, PositionRepository positionRepository) {
        this.workerRepository = workerRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        positionRepository.save(createPositionsList());
        workerRepository.save(createWorkersList(positionRepository.findAll()));

    }

    private List<Position> createPositionsList() {
        String[] array = {"JUNIOR_DEV", "MIDDLE_DEV", "SENIOR_DEV",};
        return Arrays.stream(array).map(positionName -> new Position(positionName)).collect(Collectors.toList());
    }

    private List<Worker> createWorkersList(Iterable<Position> positionList) {
        List<Worker> workersList = new ArrayList<>();
        for (Position position : positionList) {
            workersList.addAll(createWorkersForPosition(position));
        }
        return workersList;
    }

    private Collection<? extends Worker> createWorkersForPosition(Position position) {
        List<Worker> workersList = new ArrayList<>();
        Random generator = new Random();
        int maxSize = generator.nextInt(4) + 1;
        for (int i = 0; i < maxSize; ++i) {
            workersList.add(createWorker(position));
        }
        return workersList;
    }

    private Worker createWorker(Position position) {
        Worker worker = new Worker();
        worker.setPosition(position);
        worker.setFirstName(firstNameGenerator().trim());
        worker.setOtherName(otherNameGenerator().trim());
        worker.setLastName(lastNameGenerator().trim());
        worker.setEmail(emailGenerator(worker).trim());
        worker.setSalary(salaryGenerator());
        return worker;
    }

    private String firstNameGenerator() {
        String[] names = {"Karol", "Tomasz", "Michal", "Wojtek", "Kamil", "Szymon", "Jakub", "Arkadiusz", "Marek", "Adam", "Leo" +
                "Walery"};
        Random generator = new Random();
        int position = generator.nextInt(names.length);
        return names[position];
    }

    private String otherNameGenerator() {
        String[] names = {"Karol2", "Tomasz2", "Michal2", "Wojtek2", "Kamil2", "Szymon2", "Jakub2", "Arkadiusz2", "Marek2", "Adam2", "Leo2" +
                "Walery2","Walenty","Maria","Marian","Stanislaw","Pawel","Albert"};
        Random generator = new Random();
        int position = generator.nextInt(names.length);
        return names[position];
    }

    private String lastNameGenerator() {
        String[] names = {"Karolik", "Zielinski", "Wisniewski", "Milik", "Lewandowski", "Grosicki", "Blaszczykowski", "Nawalka" +
                "Boniek", "Szczesny", "Kurzawa", "Witkacy", "Warynski", "Wrona", "Panek", "Rozenek"};
        Random generator = new Random();
        int position = generator.nextInt(names.length);
        return names[position];
    }

    private String emailGenerator(Worker worker) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(worker.getFirstName());
        stringBuilder.append(worker.getOtherName());
        stringBuilder.append(worker.getLastName());
        stringBuilder.append("@company.com");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private BigDecimal salaryGenerator() {
        Random generator = new Random();
        int salary = generator.nextInt(100000);
        return new BigDecimal(salary);
    }

}
