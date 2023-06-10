package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "ChatLieu")
@Table(name = "CHATLIEU")
@Data
public class ChatLieu {
    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "MACHATLIEU")
    private String maChatLieu;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "NGAYTAO")
    private Date ngayTao;

    @Column(name = "NGAYSUA")
    private Date ngaySua;
}
