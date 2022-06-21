package com.codingdojo.dojosandninjas.controllers;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.services.NinjaService;
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
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;
    public NinjaController(NinjaService ninjaService, DojoService dojoService){
        
    	this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
    
    @RequestMapping(value="/showninjas")
    	public String index(@ModelAttribute("dojo") Ninja ninja, Model model) {
    		List<Ninja> ninjas = ninjaService.allNinjas();
    		model.addAttribute("ninja", ninjas);
    		return "index.jsp";
    	}
    
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
    	model.addAttribute("dojos", dojoService.allDojos());
        return "/newninja.jsp";
    }
    
    @GetMapping("/ninjas/{id}")
    public String getOne(@PathVariable("id") Long id, Model model) {
    	Ninja ninja = ninjaService.findNinja(id);
    	model.addAttribute("ninja", ninja);
    	return "details.jsp";
    }
    
    // Note: We'll be altering this a bit after we introduce data binding.
    @PostMapping("/ninjas")
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
    	if (result.hasErrors()) {
            return "/newninja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/ninjas/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Ninja ninja = ninjaService.findNinja(id);
        model.addAttribute("ninja", ninja);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/editninja/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/expenses/edit/{id}";
        } else {
            ninjaService.updateNinja(ninja);
            return "redirect:/";
        }
    }


    @PutMapping(value="/ninjas/update/{id}")
    public Ninja update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="firstname") String firstname,
    		@RequestParam(value="lastname") String lastname,
    		@RequestParam(value="age") int age,
    		@RequestParam(value="dojo") Dojo dojo) {
        Ninja ninja = ninjaService.updateNinja(id, firstname, lastname, age, dojo);
        return ninja;
    }
    
    @DeleteMapping(value="/ninjas/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/";
    }
}
