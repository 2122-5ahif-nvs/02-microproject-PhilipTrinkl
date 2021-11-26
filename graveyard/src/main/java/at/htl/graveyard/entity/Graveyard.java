package at.htl.graveyard.entity;

import javax.persistence.*;

@Entity
@Table(name = "G_Graveyard")
@NamedQueries({
        @NamedQuery(
                name = "Graveyard.findAll",
                query = "select g from Graveyard g"
        ),
        @NamedQuery(
                name = "Graveyard.findByName",
                query = "select g from Graveyard g where g.name = :NAME"
        ),
        @NamedQuery(
                name = "Graveyard.findById",
                query = "select g from Graveyard g where g.id = :ID"
        )

})
public class Graveyard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    public Graveyard() {
    }

    public Graveyard(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
