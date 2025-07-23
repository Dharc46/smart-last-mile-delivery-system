package com.example.smartlastmiledeliverysystem.controller;

import com.example.smartlastmiledeliverysystem.entity.Shipper;
import com.example.smartlastmiledeliverysystem.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippers") // Tiền tố chung cho tất cả API của Shipper
public class ShipperController {

    @Autowired
    private ShipperService shipperService;

    // GET: Lấy tất cả shippers
    @GetMapping
    public List<Shipper> getAllShippers() {
        return shipperService.getAllShippers();
    }

    // GET: Lấy shipper theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Shipper> getShipperById(@PathVariable Long id) {
        return ResponseEntity.ok(shipperService.getShipperById(id));
    }

    // POST: Tạo shipper mới
    @PostMapping
    public ResponseEntity<Shipper> createShipper(@RequestBody Shipper shipper) {
        Shipper createdShipper = shipperService.createShipper(shipper);
        return ResponseEntity.ok(createdShipper);
    }

    // PUT: Cập nhật thông tin shipper
    @PutMapping("/{id}")
    public ResponseEntity<Shipper> updateShipper(@PathVariable Long id, @RequestBody Shipper shipperDetails) {
        Shipper updatedShipper = shipperService.updateShipper(id, shipperDetails);
        return ResponseEntity.ok(updatedShipper);
    }

    // DELETE: Xóa shipper
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipper(@PathVariable Long id) {
        shipperService.deleteShipper(id);
        return ResponseEntity.noContent().build(); // Trả về status 204 No Content
    }
}