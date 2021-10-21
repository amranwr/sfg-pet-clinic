package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.Specialty;
import amr.springproject.sfgpetclinic.repositories.SpecialtyRepo;
import amr.springproject.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPAService")
public class SpecialtySDJpaService implements SpecialtyService {
    private final SpecialtyRepo specialtyRepo;

    public SpecialtySDJpaService(SpecialtyRepo specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepo.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepo.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepo.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepo.deleteById(aLong);
    }
}
