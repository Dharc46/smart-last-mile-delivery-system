package com.example.smartlastmiledeliverysystem.service;

import com.example.smartlastmiledeliverysystem.entity.Shipper;
import com.example.smartlastmiledeliverysystem.repository.ShipperRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    public List<Shipper> getAllShippers() {
        return shipperRepository.findAll();
    }

    public Shipper getShipperById(Long id) {
        return shipperRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipper not found with id: " + id));
    }

    public Shipper createShipper(Shipper shipper) {
        return shipperRepository.save(shipper);
    }

    public Shipper updateShipper(Long id, Shipper shipperDetails) {
        Shipper existingShipper = getShipperById(id);
        existingShipper.setFullName(shipperDetails.getFullName());
        existingShipper.setPhoneNumber(shipperDetails.getPhoneNumber());
        return shipperRepository.save(existingShipper);
    }

    public void deleteShipper(Long id) {
        Shipper shipper = getShipperById(id);
        shipperRepository.delete(shipper);
    }
}