package amr.springproject.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
public class Visit extends  BaseEntity{
    @Column(name = "localdate")
    private LocalDate localDate;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Builder
    public Visit(Long id, LocalDate localDate, String description, Pet pet) {
        super(id);
        this.localDate = localDate;
        this.description = description;
        this.pet = pet;
    }
}
