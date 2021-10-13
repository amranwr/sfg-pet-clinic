package amr.springproject.sfgpetclinic.controllers;

import amr.springproject.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    VetServiceMap vet ;
    public VetController(VetServiceMap vet){
        this.vet = vet;
    }
    @RequestMapping(path = "/vetIndex")
    public String getVetIndex(Model model){
        model.addAttribute("vets",this.vet.findAll());
        return "vet/index";
    }
}
