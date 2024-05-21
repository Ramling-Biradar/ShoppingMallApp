package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.ShopOwner;
import com.project.repos.ShopOwnerRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShopOwnerService {

    @Autowired
    private ShopOwnerRepository shopOwnerRepository;

    public List<ShopOwner> listAll() {
        return shopOwnerRepository.findAll();
    }

    public void addShopOwner(ShopOwner shopOwner) {
        shopOwnerRepository.save(shopOwner);
    }

    public ShopOwner get(int id) {
        return shopOwnerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ShopOwner not found"));
    }

    public void updateShopOwner(ShopOwner shopOwner) {
        shopOwnerRepository.save(shopOwner);
    }

    public void deleteShopOwner(int id) {
        shopOwnerRepository.deleteById(id);
    }
}
