package amr.springproject.sfgpetclinic.controllers;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.services.OwnerService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;
    private static final String OWNERFORM =  "owner/createOrUpdateOwnerForm";

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(path = "")
    public String getOwnerIndex(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owner/index";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView displayOwner(@PathVariable String ownerId){
        ModelAndView mav = new ModelAndView("owner/ownerDetails");
        mav.addObject(ownerService.findById(Long.valueOf(ownerId)));
        return mav;
    }
    @GetMapping("/find")
    public String findOwnersForm(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return "owner/findOwners";
    }

    @GetMapping("/findOwners")
    public String findOwners( Owner owner , BindingResult result , Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> owners = ownerService.findByLastNameLike("%"+owner.getLastName()+"%");
        if(owners.size() == 1 ){
            Owner temp = owners.get(0);
            return "redirect:owners/"+temp.getId();
        }else if (owners.isEmpty()){
            result.rejectValue("lastName","notFound","not found");
            return "owner/findOwners";
        }else{
            model.addAttribute("selections",owners);
            return "owner/ownersList";
        }
    }

    @GetMapping("/new")
    public String addNewOwnerForm(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return OWNERFORM;
    }
    @PostMapping("/new")
    public String addNewOwner(@Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return OWNERFORM;
        }else{
            Owner owner1 = ownerService.save(owner);
            return "redirect:/owners/"+owner1.getId();
        }
    }

    @GetMapping("/{ownerId}/update")
    public String updateOwnerForm(@PathVariable Long ownerId, Model model){
        model.addAttribute("owner",ownerService.findById(ownerId));
        return OWNERFORM;
    }

    @PostMapping("{id}/update")
    public String updateOwner(Owner owner ,@PathVariable String id, BindingResult result){
        if(result.hasErrors()){
            return OWNERFORM;
        }else{
            owner.setId(Long.valueOf(id));
            Owner owner1 = ownerService.save(owner);
            return "redirect:/owners/"+owner1.getId();
        }
    }
}
