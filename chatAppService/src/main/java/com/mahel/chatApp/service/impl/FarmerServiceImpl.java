package com.mahel.chatApp.service.impl;

import com.mahel.chatApp.entity.Farmer;
import com.mahel.chatApp.repository.FarmerRepository;
import com.mahel.chatApp.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FarmerServiceImpl implements FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public Farmer saveFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    @Override
    public Farmer updateFarmer(Farmer farmer, Long id) {

        Optional<Farmer> farmer1 = farmerRepository.findById(id);

        if (farmer1.isEmpty()) {
            throw new RuntimeException("Farmer not Found");
        }

        if (!Objects.equals(farmer1.get().getFirstName(), farmer.getFirstName())) {
            farmer1.get().setFirstName(farmer.getFirstName());
        }
        if (!Objects.equals(farmer1.get().getLastName(), farmer.getLastName())) {
            farmer1.get().setLastName(farmer.getLastName());
        }
        if (!Objects.equals(farmer1.get().getAddress(), farmer.getAddress())) {
            farmer1.get().setAddress(farmer.getAddress());
        }
        if (!Objects.equals(farmer1.get().getCity(), farmer.getCity())) {
            farmer1.get().setCity(farmer.getCity());
        }
        if (!Objects.equals(farmer1.get().getPhone(), farmer.getPhone())) {
            farmer1.get().setPhone(farmer.getPhone());
        }

        return farmerRepository.save(farmer1.get());
    }

    @Override
    public void deleteFarmer(Long id) {
        farmerRepository.deleteById(id);
    }

    @Override
    public Farmer getFarmer(Long id) {

        Optional<Farmer> farmer = farmerRepository.findById(id);

        if (farmer.isEmpty()) {
            throw new RuntimeException("Farmer not found");
        }

        return farmer.get();
    }

    @Override
    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }
}
