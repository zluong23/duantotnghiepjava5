package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.Size;
import com.example.duanquanaojava5.Repository.SizeRepository;
import com.example.duanquanaojava5.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    SizeRepository sizeRepository;

    @Override
    public ArrayList<Size> getAll() {
        return (ArrayList<Size>) sizeRepository.findAll();
    }

    @Override
    public Optional<Size> findById(UUID id) {
        return sizeRepository.findById(id);
    }
}
