package amr.springproject.sfgpetclinic.bootStrap;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.model.Vet;
import amr.springproject.sfgpetclinic.services.OwnerService;
import amr.springproject.sfgpetclinic.services.VetService;
import amr.springproject.sfgpetclinic.services.map.OwnerMapService;
import amr.springproject.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("amr");
        owner.setLastName("anwr");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("rana");
        owner1.setLastName("anwr");
        ownerService.save(owner);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("lucy");
        vet.setLastName("vavr");
        vetService.save(vet);

        System.out.println("load vets");
    }
}
