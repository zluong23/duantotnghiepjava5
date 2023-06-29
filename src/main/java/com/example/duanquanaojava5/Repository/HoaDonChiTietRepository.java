package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.HoaDonChiTiet;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
}
