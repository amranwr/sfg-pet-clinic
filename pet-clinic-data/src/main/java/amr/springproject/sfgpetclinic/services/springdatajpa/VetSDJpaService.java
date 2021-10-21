package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.Vet;
import amr.springproject.sfgpetclinic.repositories.VetRepo;
import amr.springproject.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPAService")
public class VetSDJpaService implements VetService {
    private final VetRepo vetRepo;

    public VetSDJpaService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepo.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepo.deleteById(aLong);
    }
}
