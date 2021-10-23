package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {
    private PetServiceMap petServiceMap;
    private int PET_SIZE = 1;
    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
    }

    @Test
    void save() {
        Pet pet = new Pet();
        assertNotNull(petServiceMap.save(pet));
        assertNotNull(petServiceMap.findAll());
    }

    @Test
    void findAll() {
        petServiceMap.save(new Pet());
        assertEquals(PET_SIZE,petServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Pet pet = new Pet();
        pet.setId(1L);
        petServiceMap.save(pet);
        assertEquals(1L,petServiceMap.findById(1L).getId());
    }

    @Test
    void delete() {
        Pet pet = new Pet();
        pet.setId(1L);
        petServiceMap.save(pet);
        petServiceMap.delete(pet);
        assertNull(petServiceMap.findById(1L));
    }

    @Test
    void deleteById() {
        Pet pet = new Pet();
        pet.setId(1L);
        petServiceMap.save(pet);
        petServiceMap.deleteById(1L);
        assertNull(petServiceMap.findById(1L));
    }
}