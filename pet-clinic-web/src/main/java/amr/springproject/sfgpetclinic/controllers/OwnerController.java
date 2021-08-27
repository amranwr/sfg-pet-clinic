package amr.springproject.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    @RequestMapping(path = "/ownerIndex")
    public String getOwnerIndex(){
        return "owner/index";
    }
}
