package amr.springproject.sfgpetclinic.bootStrap;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.model.Vet;
import amr.springproject.sfgpetclinic.services.OwnerService;
import amr.springproject.sfgpetclinic.services.VetService;
import amr.springproject.sfgpetclinic.services.map.OwnerMapService;
import amr.springproject.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerMapService ownerService, VetServiceMap vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ana fen");
        Owner owner = new Owner();
        owner.setFirstName("amr");
        owner.setLastName("anwr");
        ownerService.save(owner);
        System.out.println(ownerService.findAll().size());
        Vet vet = new Vet();
        vet.setFirstName("rana");
        vet.setLastName("anwr");
        this.vetService.save(vet);

        System.out.println("data is loaded............");
    }
}
