package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "ChucVu")
@Table(name = "ChucVu")
@Data
public class ChucVu {
    @Id
    @Column(name = "MaChucVu", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID maChucVu;

    @Column(name = "TenChucVu")
    private String ten;

}
