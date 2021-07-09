package com.testesondaapplication.testesondaapplication;

import com.testesondaapplication.testesondaapplication.model.Airplane;
import com.testesondaapplication.testesondaapplication.service.Airplaneservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class Airplaneresources {
    private final Airplaneservice airplaneservice;

    public Airplaneresources(Airplaneservice airplaneservice) {
        this.airplaneservice = airplaneservice;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Airplane>> getAllAirplanes (){
        List<Airplane> airplanes = airplaneservice.findAllAirplane();
        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Airplane> findAirplaneById (@PathVariable("id") Long id){
        Airplane airplane = airplaneservice.findAirplaneById(id);
        return new ResponseEntity<>(airplane, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Airplane> addAirplane(@RequestBody Airplane airplane){
        Airplane newAirplane = airplaneservice.addairplane(airplane);
        return new ResponseEntity<>(newAirplane, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Airplane> updateAirplane(@RequestBody Airplane airplane){
        Airplane updateAirplane = airplaneservice.updateAirplane(airplane);
        return new ResponseEntity<>(updateAirplane, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAirplane(@PathVariable("id") Long id){
        airplaneservice.deleteAirplane(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
