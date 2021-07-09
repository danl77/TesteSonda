package com.testesondaapplication.testesondaapplication.service;

import com.testesondaapplication.testesondaapplication.exception.UserNotFoundException;
import com.testesondaapplication.testesondaapplication.model.Airplane;
import com.testesondaapplication.testesondaapplication.repo.Airplanerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@Transactional
@Service
@RestController
public class Airplaneservice {
    @Autowired
    private final Airplanerepo airplanerepo;

    public Airplaneservice(Airplanerepo airplanerepo) {
        this.airplanerepo = airplanerepo;
    }

    public Airplane addairplane(Airplane airplane){
        airplane.setCreated(new Date());
        return airplanerepo.save(airplane);
    }

    public List<Airplane> findAllAirplane(){
        return airplanerepo.findAll();
    }

    public Airplane updateAirplane(Airplane airplane){
        airplane.setUpdated(new Date());
        return airplanerepo.save(airplane);
    }

    public Airplane findAirplaneById(Long id){
        return  airplanerepo.findAirplaneById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " not found"));
    }

    public void deleteAirplane(Long id){
        airplanerepo.deleteAirplaneById(id);
    }

}
