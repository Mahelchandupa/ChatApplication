package com.mahel.chatApp.controller;

import com.mahel.chatApp.entity.Farmer;
import com.mahel.chatApp.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmerController {
    private final FarmerService farmerService;

    @Autowired
    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public ResponseEntity<Farmer> save(@RequestBody Farmer farmer) {
        Farmer savedFarmer = farmerService.saveFarmer(farmer);
        return new ResponseEntity<>(savedFarmer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmer> update(@RequestBody Farmer farmer, @PathVariable Long id) {
        Farmer updatedFarmer = farmerService.updateFarmer(farmer, id);
        return new ResponseEntity<>(updatedFarmer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmer(@PathVariable Long id) {
        Farmer farmer = farmerService.getFarmer(id);
        return new ResponseEntity<>(farmer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        List<Farmer> farmers = farmerService.getAllFarmers();
        return new ResponseEntity<>(farmers, HttpStatus.OK);
    }
}
