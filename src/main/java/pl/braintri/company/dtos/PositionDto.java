package pl.braintri.company.dtos;

import java.io.Serializable;

public class PositionDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Long ammountOfAssignedWorkers;

    public PositionDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmmountOfAssignedWorkers() {
        return ammountOfAssignedWorkers;
    }

    public void setAmmountOfAssignedWorkers(Long ammountOfAssignedWorkers) {
        this.ammountOfAssignedWorkers = ammountOfAssignedWorkers;
    }
}
