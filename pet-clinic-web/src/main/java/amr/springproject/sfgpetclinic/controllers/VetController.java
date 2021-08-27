package amr.springproject.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    @RequestMapping(path = "/vetIndex")
    public String getVetIndex(){
        return "vet/index";
    }
}
