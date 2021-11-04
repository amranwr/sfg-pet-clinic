package amr.springproject.sfgpetclinic.controllers;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void getOwnerIndex() throws Exception {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/ownerIndex"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }

    @Test
    void displayOwnerTest()throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(get("/owner/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                        .andExpect(view().name("owner/ownerDetails"));
        verify(ownerService,times(1)).findById(anyLong());
    }
    @Test
    void findOwnersNotFound()throws Exception{
        when(ownerService.findByLastNameLike(anyString())).thenReturn(Arrays.asList());
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/findOwners"));
        verify(ownerService,times(1)).findByLastNameLike(anyString());
    }

    @Test
    void findOwnersOnlyOneFound()throws Exception{
        when(ownerService.findByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build()));
        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:owner/1"));
        verify(ownerService,times(1)).findByLastNameLike(anyString());
    }

    @Test
    void findOwnersMoreThanOne()throws Exception{
        when(ownerService.findByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build()
        ,Owner.builder().id(2L).build()));
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/ownersList"));
        verify(ownerService,times(1)).findByLastNameLike(anyString());
    }
}