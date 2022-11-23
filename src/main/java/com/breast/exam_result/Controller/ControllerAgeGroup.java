package com.breast.exam_result.Controller;

import com.breast.exam_result.Repo.AgeGroupRepo;
import com.breast.exam_result.entities.AgeGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ControllerAgeGroup {

    private AgeGroupRepo frepository;

    public ControllerAgeGroup(AgeGroupRepo frepository) {
        this.frepository = frepository;
    }

    @GetMapping("/ageGroup")
    public ResponseEntity<?> findALLAgeGroup(){
        try {
            List<AgeGroup> lista = frepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ageGroup/{id}")
    public ResponseEntity<?> findByIdAgeGroup(@PathVariable long id){
        try {
            Optional<AgeGroup> unidOptional = frepository.findById(id);
            if (unidOptional.isPresent()){
                AgeGroup ageGroupUnid =unidOptional.get();
                return new ResponseEntity<>(ageGroupUnid, HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/ageGroup/novo")
    public AgeGroup newAgeGroup(@RequestBody AgeGroup newAge){
        return frepository.save(newAge);
    }

    @DeleteMapping("/ageGroup/remover/{id}")
        public void deleteAgeGroup(@PathVariable long id){
            frepository.deleteById(id);
        }
}
