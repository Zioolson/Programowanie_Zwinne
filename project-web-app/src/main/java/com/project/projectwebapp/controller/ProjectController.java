package com.project.projectwebapp.controller;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import com.project.projectwebapp.model.Projekt;
import com.project.projectwebapp.service.ProjektService;
@Controller
public class ProjectController {
    private ProjektService projektService;
    public ProjectController(ProjektService projektService) {
        this.projektService = projektService;
    }
    @GetMapping("/projektList")
    public String projektList(Model model, Pageable pageable) {
        model.addAttribute("projekty", projektService.getProjekty(pageable).getContent());
        return "projektList";
    }

    @GetMapping("/projektEdit")
    public String projektEdit(@RequestParam(required = false) Integer projektId, Model model) {
        if(projektId != null) {
            model.addAttribute("projekt", projektService.getProjekt(projektId).get());
        }else {
            Projekt projekt = new Projekt();
            model.addAttribute("projekt", projekt);
        }
        return "projektEdit";
    }
    @PostMapping(path = "/projektEdit")
    public String projektEditSave(@ModelAttribute @Valid Projekt projekt, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "projektEdit";
        }
        try {
            projekt = projektService.setProjekt(projekt);
        } catch (HttpStatusCodeException e) {
            bindingResult.rejectValue(null, String.valueOf(e.getStatusCode().value()),
                    e.getStatusCode().getReasonPhrase());
            return "projektEdit";
        }
        return "redirect:/projektList";
    }

    @PostMapping(params="cancel", path = "/projektEdit")
    public String projektEditCancel() { // żądanie będzie zawierało parametr 'cancel'
        return "redirect:/projektList";
    }

    @PostMapping(params="delete", path = "/projektEdit")
    public String projektEditDelete(@ModelAttribute Projekt projekt) {
        projektService.deleteProjekt(projekt.getProjektId());
        return "redirect:/projektList";
    }
}