package com.example.smartlastmiledeliverysystem.repository;

import com.example.smartlastmiledeliverysystem.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    // Spring Data JPA sẽ tự động cung cấp các phương thức CRUD cơ bản.
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh ở đây nếu cần.
}