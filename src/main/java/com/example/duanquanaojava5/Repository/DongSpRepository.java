package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DongSpRepository extends JpaRepository<DongSP, UUID> {
}
