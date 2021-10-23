package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.Pet;
import amr.springproject.sfgpetclinic.repositories.PetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {
    @Mock
    private PetRepo petRepo;
    @InjectMocks
    private PetSDJpaService petSDJpaService;
    @BeforeEach
    void setUp() {

    }

    @Test
    void save() {
        Pet pet = Pet.builder().id(1L).build();
        when(petRepo.save(any())).thenReturn(pet);
        assertEquals(pet,petSDJpaService.save(pet));
    }

    @Test
    void findAll() {
        Set<Pet> petSet = new HashSet<>();
        petSet.add(new Pet());
        when(petRepo.findAll()).thenReturn(petSet);
        assertEquals(petSet.size(), petSDJpaService.findAll().size());
    }

    @Test
    void findById() {
        Pet pet = Pet.builder().id(1L).build();
        when(petRepo.findById(any())).thenReturn(Optional.ofNullable(pet));
        assertEquals(1L,petSDJpaService.findById(1L).getId());
    }

    @Test
    void delete() {
        petSDJpaService.delete(any());
        verify(petRepo,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        petSDJpaService.deleteById(any());
        verify(petRepo).deleteById(any());
    }
}