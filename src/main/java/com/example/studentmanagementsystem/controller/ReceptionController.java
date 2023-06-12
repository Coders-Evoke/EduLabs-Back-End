package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.exception.ResourceNotFoundException;
import com.example.studentmanagementsystem.model.Reception;
import com.example.studentmanagementsystem.repository.ReceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ReceptionController {
    @Autowired
    private ReceptionRepository receptionRepository;

    //Get all receptions
    @GetMapping("/reception")
    public List<Reception> getAllReception(){
        return receptionRepository.findAll();
    }

    //Create receptions rest API
    @PostMapping("/reception")
    public Reception createReception(@RequestBody Reception reception){

        return receptionRepository.save(reception);
    }

    //Get reception by id rest api
    @GetMapping("/reception/{id}")
    public ResponseEntity<Reception> getReceptionById(@PathVariable int id){
        Reception reception = receptionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Reception not exist with Id:"+id));
        return ResponseEntity.ok(reception);
    }

    //Update reception rest api
    @PutMapping("/reception/{id}")
    public ResponseEntity<Reception> updateReception(@PathVariable int id, @RequestBody Reception receptionDetails){
        Reception reception = receptionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Reception not exist with Id:"+id));
        reception.setFirstName(receptionDetails.getFirstName());
        reception.setLastName(receptionDetails.getLastName());
        reception.setMobileNumber(receptionDetails.getMobileNumber());
        reception.setAddress(receptionDetails.getAddress());
        Reception updatedReception = receptionRepository.save(reception);
        return ResponseEntity.ok(updatedReception);
    }

    //Delete reception rest api
    @DeleteMapping("/reception/{id}")
    public ResponseEntity <Map<String, Boolean>>deleteReception(@PathVariable int id){
        Reception reception = receptionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Reception not exist with Id:"+id));

        receptionRepository.delete(reception);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
