package amr.springproject.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity{
    @Column(name = "description")
    private String description;
    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
