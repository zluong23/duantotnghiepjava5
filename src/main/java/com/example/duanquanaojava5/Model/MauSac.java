package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Khong dc de trong")
    private String tenMauSac;

}
