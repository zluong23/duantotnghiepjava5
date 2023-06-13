package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "DongSP")
@Table(name = "DongSP")
@Data
public class DongSP {
    @Id
    @Column(name = "MaDongSP", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDongSP;


    @Column(name = "TenDongSP")
    private String tenDongSP;


}
