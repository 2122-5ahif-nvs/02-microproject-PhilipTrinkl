package at.htl.graveyard.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "G_Gravestone")
@NamedQueries({
        @NamedQuery(
                name = "Gravestone.findAll",
                query = "select g from Gravestone g"
        ),
        @NamedQuery(
                name = "Gravestone.findByName",
                query = "select g from Gravestone g where g.inscription = :NAME"
        ),
        @NamedQuery(
                name = "Gravestone.findById",
                query = "select g from Gravestone g where g.Id = :ID"
        )

})
public class Gravestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    String name;
    LocalDate dateofdeath;
    private String inscription;

    @ManyToOne
    Grave grave;

    public Gravestone(Long id, String inscription, Grave grave, LocalDate dateofdeath, String name) {
        this.Id = id;
        this.inscription = inscription;
        this.name = name;
        this.dateofdeath = dateofdeath;
        this.grave = grave;

    }

    public Gravestone() {
    }

    public Long getId() {
        return Id;
    }

    public String getInscription() {
        return inscription;
    }

    public void setInscription(String name) {
        this.inscription = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateofdeath() {
        return dateofdeath;
    }

    public void setDateofdeath(LocalDate dateofdeath) {
        this.dateofdeath = dateofdeath;
    }
}
