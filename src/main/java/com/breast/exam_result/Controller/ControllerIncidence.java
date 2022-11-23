package com.breast.exam_result.Controller;

import com.breast.exam_result.Repo.IncidenceRepo;
import com.breast.exam_result.entities.Incidence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerIncidence {
    private final IncidenceRepo ocRepository;

    public ControllerIncidence(Incidence ocRepository){
        this.ocRepository = (IncidenceRepo) ocRepository;
    }

    @GetMapping("/incidence")
    public ResponseEntity<List<Incidence>> findIncidence(){
        List<Incidence> listaIncidence = ocRepository.findAll();
        if (listaIncidence.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("incidence/{id}")
    public ResponseEntity<Incidence> findIncidenceById(@PathVariable Long id){
        Optional<Incidence>incidenceOptional =ocRepository.findById(id);
        if(incidenceOptional.isPresent()){
            Incidence incidenceUnid = incidenceOptional.get();
            return new ResponseEntity<>(incidenceUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/incidence/novo")
    public Incidence newIncidence(@RequestBody Incidence newIncidence){
        return ocRepository.save(newIncidence);
    }

 }
