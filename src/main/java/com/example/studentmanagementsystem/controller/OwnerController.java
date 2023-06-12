package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.exception.ResourceNotFoundException;
import com.example.studentmanagementsystem.model.Owner;
import com.example.studentmanagementsystem.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    //Get all owners
    @GetMapping("/owner")
    public List<Owner> getAllOwner(){
        return ownerRepository.findAll();
    }

    //Create owners rest API
    @PostMapping("/owner")
    public Owner createOwner(@RequestBody Owner owner){
        return ownerRepository.save(owner);
    }

    //Get owner by id rest api
    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable int id){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Owner not exist with Id:"+id));
        return ResponseEntity.ok(owner);
    }

    //Update owner rest api
    @PutMapping("/owner/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable int id, @RequestBody Owner ownerDetails){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Owner not exist with Id:"+id));
        owner.setFirstName(ownerDetails.getFirstName());
        owner.setLastName(ownerDetails.getLastName());
        owner.setMobileNumber(ownerDetails.getMobileNumber());
        owner.setAddress(ownerDetails.getAddress());

        Owner updatedOwner = ownerRepository.save(owner);
        return ResponseEntity.ok(updatedOwner);
    }

    //Delete owner rest api
    @DeleteMapping("/owner/{id}")
    public ResponseEntity <Map<String, Boolean>>deleteOwner(@PathVariable int id){
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Owner not exist with Id:"+id));

        ownerRepository.delete(owner);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
