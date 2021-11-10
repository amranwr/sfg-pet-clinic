package amr.springproject.sfgpetclinic.controllers;

import amr.springproject.sfgpetclinic.model.Vet;
import amr.springproject.sfgpetclinic.services.VetService;
import amr.springproject.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {
    private final VetService vet ;
    public VetController(VetService vet){
        this.vet = vet;
    }
    @RequestMapping(path = {"/vetIndex","/vets.html"})
    public String getVetIndex(Model model){
        model.addAttribute("vets",this.vet.findAll());
        return "vet/index";
    }

    @GetMapping("api/vets")
    public @ResponseBody Set<Vet> getVetsJSON(){
        return vet.findAll();
    }
}
