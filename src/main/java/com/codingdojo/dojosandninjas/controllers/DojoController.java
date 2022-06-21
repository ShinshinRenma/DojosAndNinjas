package com.codingdojo.dojosandninjas.controllers;
import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.services.DojoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DojoController {
    private final DojoService dojoService;
    public DojoController(DojoService dojoService){
        this.dojoService = dojoService;
    }
    
    @RequestMapping(value="/")
    	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
    		List<Dojo> dojos = dojoService.allDojos();
    		model.addAttribute("dojos", dojos);
    		return "index.jsp";
    	}
    
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "/newdojo.jsp";
    }
    
    @GetMapping("/dojos/{id}")
    public String getOne(@PathVariable("id") Long id, Model model) {
    	Dojo dojo = dojoService.findDojo(id);
    	model.addAttribute("dojo", dojo);
    	return "displaydojo.jsp";
    }
    
    // Note: We'll be altering this a bit after we introduce data binding.
    @PostMapping("/dojos")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
    	if (result.hasErrors()) {
            return "/index.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/dojos/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/expenses/edit/{id}";
        } else {
            dojoService.updateDojo(dojo);
            return "redirect:/";
        }
    }


    @PutMapping(value="/dojos/update/{id}")
    public Dojo update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="name") String name) {
        Dojo dojo = dojoService.updateDojo(id, name);
        return dojo;
    }
    
    @DeleteMapping(value="/dojos/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        dojoService.deleteDojo(id);
        return "redirect:/";
    }
}
