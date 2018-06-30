package pl.braintri.company.dtos;

import pl.braintri.company.domain.entities.Position;

import java.io.Serializable;
import java.math.BigDecimal;

public class WorkerDto implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    String firstName;
    String otherName;
    String lastName;
    String email;
    PositionDto position;
    BigDecimal salary;

    public WorkerDto() {
    }

    public WorkerDto(Long id, String firstName, String otherName, String lastName, String email, PositionDto position, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.otherName = otherName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.salary = salary;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }
}
