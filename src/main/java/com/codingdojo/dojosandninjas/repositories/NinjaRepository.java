package com.codingdojo.dojosandninjas.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.dojosandninjas.models.Ninja;
import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
    // this method retrieves all the books from the database
    List<Ninja> findAll();
}
    
    

