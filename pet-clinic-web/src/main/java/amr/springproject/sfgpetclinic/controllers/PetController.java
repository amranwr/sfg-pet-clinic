package amr.springproject.sfgpetclinic.controllers;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.model.Pet;
import amr.springproject.sfgpetclinic.model.PetType;
import amr.springproject.sfgpetclinic.services.OwnerService;
import amr.springproject.sfgpetclinic.services.PetService;
import amr.springproject.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private static final String CREATEORUPDATEFORM = "pets/createOrUpdatePetForm";
    private OwnerService ownerService;
    private PetService petService;
    private PetTypeService petTypeService;

    public PetController(OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }



    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String getNewPetForm(Owner owner, Model model){
        Pet pet = new Pet();
        owner.addPet(pet);
        model.addAttribute("pet",pet);
        return CREATEORUPDATEFORM;
    }

    @PostMapping("pets/new")
    public String saveNewPet( Pet pet, Owner owner, Model model, BindingResult result){
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.addPet(pet);
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return CREATEORUPDATEFORM;
        } else {
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String getUpdatePetForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return CREATEORUPDATEFORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String updatePet( Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return CREATEORUPDATEFORM;
        } else {
            petService.updateExistingPet(owner.getId(),pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

}
