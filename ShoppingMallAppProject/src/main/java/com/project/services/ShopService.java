package com.project.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.Shop;
import com.project.repos.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> listAll() {
        return shopRepository.findAll();
    }

    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }

    public Shop get(int id) {
        return shopRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Shop not found"));
    }

    public void updateShop(Shop shop) {
        shopRepository.save(shop);
    }

    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }
}