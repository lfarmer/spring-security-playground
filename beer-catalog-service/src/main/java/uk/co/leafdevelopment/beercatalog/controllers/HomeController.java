package uk.co.leafdevelopment.beercatalog.controllers;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        OAuth2Authentication outhPrincipal = (OAuth2Authentication) principal;
        model.addAttribute("user", outhPrincipal.getUserAuthentication().getDetails());
        return "home";
    }

}
