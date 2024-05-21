package com.project.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Mall;
import com.project.repos.MallRepository;

import java.util.List;

@Service
public class MallService {

    @Autowired
    private MallRepository mallRepository;

    public List<Mall> getAllMalls() {
        return mallRepository.findAll();
    }

    public Mall getMallById(Long id) {
        return mallRepository.findById(id).orElse(null);
    }

    public Mall createOrUpdateMall(Mall mall) {
        return mallRepository.save(mall);
    }

    public void deleteMall(Long id) {
        mallRepository.deleteById(id);
    }
    public Mall updateMall(Long id, Mall updatedMall) {
        if (mallRepository.existsById(id)) {
            Mall existingMall = mallRepository.findById(id).orElse(null);
            if (existingMall != null) {
                existingMall.setMallName(updatedMall.getMallName());
                existingMall.setLocation(updatedMall.getLocation());
                existingMall.setCategories(updatedMall.getCategories());
                // You can update other fields as needed
                return mallRepository.save(existingMall);
            }
        }
        return null; // Mall not found or update failed
    }
}
