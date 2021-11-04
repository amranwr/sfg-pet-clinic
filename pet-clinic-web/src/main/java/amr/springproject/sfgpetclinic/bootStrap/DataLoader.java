package amr.springproject.sfgpetclinic.bootStrap;

import amr.springproject.sfgpetclinic.model.*;
import amr.springproject.sfgpetclinic.services.*;
import amr.springproject.sfgpetclinic.services.map.OwnerMapService;
import amr.springproject.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petService.findAll().size();
        if(count == 0 ){
            loadData();
        }
    }

    private void loadData() {
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
        cat.setName("cat");
        this.petTypeService.save(cat);
        System.out.println("ana fen");
        Owner owner = new Owner();
        owner.setFirstName("amr");
        owner.setLastName("anwr");
        owner.setAddress("cairo");
        owner.setCity("cairo");
        owner.setTelephone("01144100945");
        Pet firstPet = new Pet();
        firstPet.setPetType(dog);
        firstPet.setBirthDate(LocalDate.now());
        firstPet.setOwner(owner);
        firstPet.setName("amrooo's dog");

        owner.addPet(firstPet);
        Owner owner2 = Owner.builder().firstName("amr").lastName("anwoor")
                        .address("Egypt").city("Cairo").telephone("01003106763")
                        .pets(new HashSet<Pet>()).build();
        Pet pet = Pet.builder().petType(cat).birthDate(LocalDate.now()).owner(owner2).name("lucky").build();
        System.out.println(pet.getName());
        owner2.addPet(pet);
        ownerService.save(owner);
        ownerService.save(owner2);
        //petService.save(firstPet);

        Visit visit = new Visit();
        visit.setPet(firstPet);
        visit.setLocalDate(LocalDate.now());
        visit.setDescription("kitty cat");
        visitService.save(visit);

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
