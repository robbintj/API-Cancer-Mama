package com.breast.exam_result.Controller;

import com.breast.exam_result.Repo.RegionRepo;
import com.breast.exam_result.entities.Region;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerRegiao {

    private final RegionRepo repository;

    public ControllerRegiao(RegionRepo repository){
        this.repository = repository;
    }
    @GetMapping("/region")
   public List<Region> getRegion(){
        return repository.findAll();
   }

   @GetMapping("/region/{id}")
   public ResponseEntity<?> getRegionById(@PathVariable Long id){
       Optional regionEscolhidaOptional =  repository.findById(id);
               if(regionEscolhidaOptional.isPresent()){
                 Object regionEscolhida = regionEscolhidaOptional.get();
                 return new ResponseEntity<>(regionEscolhida, HttpStatus.OK);
               }
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   @PutMapping("/region/novo")
   public Region PutRegion(@RequestBody Region newRegion){
        return repository.save(newRegion);
   }
   @DeleteMapping("/region/delete/{id}")
   public void deleteRegion(@PathVariable Long id){
        repository.deleteById(id);

   }
}
