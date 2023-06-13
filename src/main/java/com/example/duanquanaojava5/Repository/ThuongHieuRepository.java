package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {
    ThuongHieu findByTenThuongHieu(String tenThuongHieu);
}
