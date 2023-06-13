package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "ThuongHieu")
@Table(name = "ThuongHieu")
@Data
public class ThuongHieu {
    @Id
    @Column(name = "MaThuongHieu", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThuongHieu;


    @Column(name = "TenThuongHieu")
    private String tenThuongHieu;

}
