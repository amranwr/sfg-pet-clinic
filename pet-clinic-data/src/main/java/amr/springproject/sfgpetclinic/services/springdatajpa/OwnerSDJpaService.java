package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.repositories.OwnerRepo;
import amr.springproject.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile("springDataJPAService")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepo ownerRepo;

    public OwnerSDJpaService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        return (Set<Owner>)ownerRepo.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Owner object) {
        ownerRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepo.deleteById(aLong);
    }
}
