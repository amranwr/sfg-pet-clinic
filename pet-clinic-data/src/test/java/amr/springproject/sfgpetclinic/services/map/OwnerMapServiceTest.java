package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.services.PetService;
import amr.springproject.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OwnerMapServiceTest {
    private OwnerMapService ownerMapService ;
    @Mock
    private PetTypeService petTypeService;
    @Mock
    private PetService petService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ownerMapService = new OwnerMapService(petService,petTypeService);
        ownerMapService.save(Owner.builder().lastName("anwr").build());
        ownerMapService.save(Owner.builder().lastName("mohamed").build());
    }



    @Test
    void save(){
        Owner owner = new Owner();
        assertEquals(owner,ownerMapService.save(owner));
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(2L,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1l);
        assertEquals(1l,owner.getId());
    }

    @Test
    void delete() {
        Owner owner = new Owner();
        owner.setId(2L);
        ownerMapService.save(owner);
        ownerMapService.delete(owner);
        assertNull(ownerMapService.findById(2L));
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertNull(ownerMapService.findById(1L));
    }


}