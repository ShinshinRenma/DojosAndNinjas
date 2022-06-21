package com.codingdojo.dojosandninjas.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.dojosandninjas.models.Dojo;
import java.util.List;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    // this method retrieves all the books from the database
    List<Dojo> findAll();
}
    
    

