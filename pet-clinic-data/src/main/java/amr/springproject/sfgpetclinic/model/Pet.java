package amr.springproject.sfgpetclinic.model;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public class Pet extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "birthdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(name = "name")
    private String name;

    @Builder
    public Pet(Long id, PetType petType, Set<Visit> visits, Owner owner, LocalDate birthDate, String name) {
        super(id);
        this.petType = petType;
        if(visits == null || visits.size()>0){
            this.visits = visits;
        }
        this.owner = owner;
        this.birthDate = birthDate;
        this.name = name;
    }
}
