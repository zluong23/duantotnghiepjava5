package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {
    ChatLieu findByTenChatLieu(String tenChatLieu);
}
