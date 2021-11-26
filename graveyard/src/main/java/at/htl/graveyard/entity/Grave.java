package at.htl.graveyard.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "G_Grave")
@NamedQueries({
        @NamedQuery(
                name = "Grave.findAll",
                query = "select g from Grave g"
        ),
        @NamedQuery(
                name = "Grave.findById",
                query = "select g from Gravestone g where g.Id = :ID"
        )

})

public class Grave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String section;
    boolean rented;
    LocalDate beginrent;
    LocalDate endrent;

    public Grave() {
    }

    public Grave(String section, boolean rented, LocalDate beginrent, LocalDate endrent){
        this.section = section;
        this.rented = rented;
        this.beginrent = beginrent;
        this.endrent = endrent;
    }

    public Long getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public LocalDate getBeginrent() {
        return beginrent;
    }

    public void setBeginrent(LocalDate beginrent) {
        this.beginrent = beginrent;
    }

    public LocalDate getEndrent() {
        return endrent;
    }

    public void setEndrent(LocalDate endrent) {
        this.endrent = endrent;
    }
}
