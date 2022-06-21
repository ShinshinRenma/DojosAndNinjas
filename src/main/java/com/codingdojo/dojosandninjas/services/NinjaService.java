package com.codingdojo.dojosandninjas.services;
import java.util.List;
import java.util.Optional;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.models.Dojo;

@Service
public class NinjaService {
    // adding the ninja repository as a dependency
	private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    // returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a ninja
    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    // Retrieves an ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    // Updates a Book
    public Ninja updateNinja(Long id, String firstname, String lastname, int age, Dojo dojo) {
    	Ninja ninja = findNinja(id);
    	if(ninja != null) {
    		ninja.setFirstName(firstname);
    		ninja.setLastName(lastname);
    		ninja.setAge(age);
    		ninja.setDojo(dojo);
    	}
    	return ninjaRepository.save(ninja);
    }
    
    // Overloaded method to update expense with expense object
    public Ninja updateNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    // Deletes a book
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }
}

