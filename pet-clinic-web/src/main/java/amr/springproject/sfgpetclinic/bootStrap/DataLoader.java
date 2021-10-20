package amr.springproject.sfgpetclinic.bootStrap;

import amr.springproject.sfgpetclinic.model.*;
import amr.springproject.sfgpetclinic.services.*;
import amr.springproject.sfgpetclinic.services.map.OwnerMapService;
import amr.springproject.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerMapService ownerService, VetServiceMap vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty massage = new Specialty();
        massage.setDescription("massage");
        specialtyService.save(surgery);
        specialtyService.save(massage);
        System.out.println("surgery id : "+surgery.getId());
        System.out.println("massage id : "+massage.getId());

        PetType dog=  new PetType();
        dog.setName("dog");
        this.petTypeService.save(dog);
        PetType cat=  new PetType();
        dog.setName("cat");
        this.petTypeService.save(cat);



        System.out.println("ana fen");
        Owner owner = new Owner();
        owner.setFirstName("amr");
        owner.setLastName("anwr");
        Pet firstPet = new Pet();
        firstPet.setPetType(dog);
        firstPet.setBirthDate(LocalDate.now());
        firstPet.setOwner(owner);
        firstPet.setName("amrooo's dog");
        owner.getPets().add(firstPet);
        ownerService.save(owner);


        System.out.println(ownerService.findAll().size());
        Vet vet = new Vet();
        vet.setFirstName("rana");
        vet.setLastName("anwr");
        vet.getSpecialities().add(surgery);
        vet.getSpecialities().add(massage);
        this.vetService.save(vet);

        System.out.println("data is loaded............");
    }
}
