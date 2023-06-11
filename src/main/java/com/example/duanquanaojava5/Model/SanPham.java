package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "SanPham")
@Table(name = "SANPHAM")
@Data
public class SanPham {
    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "MASP")
    @NotBlank(message = "khong duoc de trong ma")
    private String MASP;

    @Column(name = "TEN")
    @NotBlank(message = "khong duoc de trong ten")
    private String TEN;

    @Column(name = "NGAYTAO")
    private Date NGAYTAO;

    @Column(name = "NGAYSUA")
    private Date NGAYSUA;


}
