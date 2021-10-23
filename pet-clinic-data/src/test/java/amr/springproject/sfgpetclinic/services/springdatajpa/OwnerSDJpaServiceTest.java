package amr.springproject.sfgpetclinic.services.springdatajpa;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.repositories.OwnerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    private OwnerRepo ownerRepo;
    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;
    @BeforeEach
    void setUp() {
    //    MockitoAnnotations.openMocks(this); // intializing mockito annotations just like on line 22
    //    ownerSDJpaService = new OwnerSDJpaService(ownerRepo);// intializing the service with the mock injected just like line 22
    }

    @Test
    void findByLastName() {

        Owner owner =  Owner.builder().lastName("amr").build();
        when(ownerRepo.findByLastName("amr")).thenReturn(owner);
        assertEquals("amr",ownerSDJpaService.findByLastName("amr").getLastName());

    }

    @Test
    void save() {
        Owner owner =Owner.builder().id(1L).build();
        ownerSDJpaService.save(owner);
        when(ownerRepo.findById(1l)).thenReturn(Optional.ofNullable(owner));
        assertEquals(1l,ownerSDJpaService.findById(1L).getId());
    }

    @Test
    void findAll() {
        Owner owner1 = Owner.builder().id(1l).build();
        Owner owner2 = Owner.builder().id(2l).build();
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(owner1);
        ownerSet.add(owner2);
        when(ownerRepo.findAll()).thenReturn(ownerSet);
        assertEquals(ownerSet.size(),ownerSDJpaService.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(1l).build();
        when(ownerRepo.findById(1l)).thenReturn(Optional.ofNullable(owner));
        assertEquals(1l,ownerSDJpaService.findById(1l).getId());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(any());
        verify(ownerRepo).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(anyLong());
       // verify(ownerRepo).deleteById(anyLong());
        verify(ownerRepo,times(1)).deleteById(anyLong());
    }
}