package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "ChatLieu")
@Table(name = "ChatLieu")
@Data
public class ChatLieu {
    @Id
    @Column(name = "MaChatLieu", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maChatLieu;

    @Column(name = "TenChatLieu")
    private String tenChatLieu;

}
