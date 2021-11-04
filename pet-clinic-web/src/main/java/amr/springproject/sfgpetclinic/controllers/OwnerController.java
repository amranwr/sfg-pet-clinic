package amr.springproject.sfgpetclinic.controllers;

import amr.springproject.sfgpetclinic.model.Owner;
import amr.springproject.sfgpetclinic.services.OwnerService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(path = "/ownerIndex")
    public String getOwnerIndex(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owner/index";
    }

    @GetMapping("owner/{ownerId}")
    public ModelAndView displayOwner(@PathVariable String ownerId){
        ModelAndView mav = new ModelAndView("owner/ownerDetails");
        mav.addObject(ownerService.findById(Long.valueOf(ownerId)));
        return mav;
    }
    @GetMapping("owners/find")
    public String findOwnersForm(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return "owner/findOwners";
    }

    @GetMapping("owners")
    public String findOwners( Owner owner , BindingResult result , Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> owners = ownerService.findByLastNameLike(owner.getLastName());
        if(owners.size() == 1 ){
            Owner temp = owners.get(0);
            return "redirect:owner/"+temp.getId();
        }else if (owners.isEmpty()){
            result.rejectValue("lastName","notFound","not found");
            return "owner/findOwners";
        }else{
            model.addAttribute("selections",owners);
            return "owner/ownersList";
        }
    }
}
