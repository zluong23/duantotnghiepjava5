package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "MauSac")
@Table(name = "MauSac")
@Data
public class MauSac {
    @Id
    @Column(name = "MaMauSac", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maMauSac;

    @Column(name = "TenMau")
    private String tenMauSac;

}
