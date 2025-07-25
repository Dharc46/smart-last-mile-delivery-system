package com.example.smartlastmiledeliverysystem.service;

import com.example.smartlastmiledeliverysystem.entity.Shipper;
import com.example.smartlastmiledeliverysystem.repository.ShipperRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // Thêm annotation này
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    @Transactional(readOnly = true) // Read-only cho các method query
    public List<Shipper> getAllShippers() {
        return shipperRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Shipper getShipperById(Long id) {
        return shipperRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipper not found with id: " + id));
    }

    @Transactional // Write transaction cho create
    public Shipper createShipper(Shipper shipper) {
        Shipper savedShipper = shipperRepository.save(shipper);
        shipperRepository.flush(); // Force flush to database
        return savedShipper;
    }

    @Transactional // Write transaction cho update
    public Shipper updateShipper(Long id, Shipper shipperDetails) {
        Shipper existingShipper = getShipperById(id);
        existingShipper.setFullName(shipperDetails.getFullName());
        existingShipper.setPhoneNumber(shipperDetails.getPhoneNumber());
        return shipperRepository.save(existingShipper);
    }

    @Transactional // Write transaction cho delete
    public void deleteShipper(Long id) {
        Shipper shipper = getShipperById(id);
        shipperRepository.delete(shipper);
    }

    @Transactional
    public void debugShipper() {
    List<Shipper> all = shipperRepository.findAll();
    System.out.println("Found shippers: " + all.size());
    all.forEach(s -> System.out.println("Shipper: " + s.getId() + " - " + s.getFullName()));
}
}