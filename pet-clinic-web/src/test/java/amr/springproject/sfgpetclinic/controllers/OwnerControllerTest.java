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
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    private OwnerService ownerService;
    @Mock
    private Model model;
    @InjectMocks
    private OwnerController ownerController;

    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void getOwnerIndex() throws Exception {
        mockMvc.perform(get("/ownerIndex"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }
}