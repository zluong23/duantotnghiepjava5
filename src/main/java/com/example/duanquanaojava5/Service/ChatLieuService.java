package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ChatLieu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatLieuService {
    ArrayList<ChatLieu> getAll();
    ChatLieu findByTenChatLieu(String tenChatLieu);
    void save(ChatLieu chatLieu);
//    Optional<ChatLieu> findById(UUID id);
}
