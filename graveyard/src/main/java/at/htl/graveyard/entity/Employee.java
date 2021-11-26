package at.htl.graveyard.entity;

import javax.persistence.*;

@Entity
@Table(name = "G_Employee")
@NamedQueries({
        @NamedQuery(
                name = "Employee.findAll",
                query = "select e from Employee e"
        ),
        @NamedQuery(
                name = "Employee.findById",
                query = "select e from Employee e where e.id = :ID"
        )

})

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;

    @ManyToOne
    Graveyard graveyard;


    public Employee() {
    }



    public Employee(Long id, String firstname, String lastname, String address, Graveyard graveyard) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.graveyard = graveyard;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(Graveyard graveyard) {
        this.graveyard = graveyard;
    }
}
