package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
