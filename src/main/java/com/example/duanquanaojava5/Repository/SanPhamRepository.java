package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
