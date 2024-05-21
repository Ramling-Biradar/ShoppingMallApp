package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.MallAdmin;
import com.project.repos.MallAdminRepository;

import java.util.List;

@Service
public class MallAdminService {

    @Autowired
    private MallAdminRepository mallAdminRepository;

    public List<MallAdmin> getAllMallAdmins() {
        return mallAdminRepository.findAll();
    }

    public MallAdmin getMallAdminById(int id) {
        return mallAdminRepository.findById(id).orElse(null);
    }

    public MallAdmin createOrUpdateMallAdmin(MallAdmin mallAdmin) {
        return mallAdminRepository.save(mallAdmin);
    }

    public void deleteMallAdmin(int id) {
        mallAdminRepository.deleteById(id);
    }
    
}
