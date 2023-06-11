package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.ChatLieu;
import com.example.duanquanaojava5.Repository.ChatLieuRepository;
import com.example.duanquanaojava5.Service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepository clRepo;

    @Override
    public ArrayList<ChatLieu> getAll() {
        return (ArrayList<ChatLieu>) clRepo.findAll();
    }

    @Override
    public Optional<ChatLieu> findById(UUID id) {
        return clRepo.findById(id);
    }
}
