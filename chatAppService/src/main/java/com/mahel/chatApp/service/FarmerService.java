package com.mahel.chatApp.service;

import com.mahel.chatApp.entity.Farmer;

import java.util.List;

public interface FarmerService {

    Farmer saveFarmer(Farmer farmer);

    Farmer updateFarmer(Farmer farmer, Long id);

    void deleteFarmer(Long id);

    Farmer getFarmer(Long id);

    List<Farmer> getAllFarmers();
}
