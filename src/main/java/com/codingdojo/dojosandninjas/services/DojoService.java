package com.codingdojo.dojosandninjas.services;
import java.util.List;
import java.util.Optional;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;
import com.codingdojo.dojosandninjas.models.Dojo;

@Service
public class DojoService {
    // adding the expense repository as a dependency
	private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // returns all the expenses
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates an expense
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    // Retrieves an expense
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    // Updates a Book
    public Dojo updateDojo(Long id, String name) {
    	Dojo dojo = findDojo(id);
    	if(dojo != null) {
    		dojo.setName(name);
    	}
    	return dojoRepository.save(dojo);
    }
    
    // Overloaded method to update expense with expense object
    public Dojo updateDojo(Dojo e) {
        return dojoRepository.save(e);
    }
    // Deletes a book
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
}

