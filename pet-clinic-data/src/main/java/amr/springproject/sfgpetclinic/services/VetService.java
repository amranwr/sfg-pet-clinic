package amr.springproject.sfgpetclinic.services;

import amr.springproject.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Set<Vet> findAll();
    boolean save(Vet vet);
    Vet findById(Vet vet);
}
