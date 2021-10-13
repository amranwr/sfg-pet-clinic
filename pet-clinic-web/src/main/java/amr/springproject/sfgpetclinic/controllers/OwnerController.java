package amr.springproject.sfgpetclinic.controllers;

import amr.springproject.sfgpetclinic.services.OwnerService;
import amr.springproject.sfgpetclinic.services.map.OwnerMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerMapService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(path = "/ownerIndex")
    public String getOwnerIndex(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owner/index";
    }
}
