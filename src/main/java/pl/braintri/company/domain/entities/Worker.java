package pl.braintri.company.domain.entities;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Worker implements Serializable, SimpleIdEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String firstName;

    @Size(max = 200)
    @Column(length = 200)
    private String otherName;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String lastName;

    @NotNull
    @Size(max = 80)
    @Column(length = 80)
    @Email
    private String email;

    @NotNull
    private BigDecimal salary;

    @NotNull
    @ManyToOne
    @JoinColumn(name="position_id")
    public Position position;

    @Version
    @Column(nullable = false)
    private Long version;

    public Worker() {
    }

    public Worker(String firstName, String otherName, String lastName, String email, BigDecimal salary, Position position) {
        this.firstName = firstName;
        this.otherName = otherName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.position = position;
    }

    public Worker(String firstName, String lastName, String email, BigDecimal salary, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.position = position;
    }

    @Override
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }



    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Worker worker = (Worker) o;
        return Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
