package com.project.controllers;

import com.project.entities.ShopOwner;
import com.project.services.ShopOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/shopowners")
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService shopOwnerService;

    @GetMapping("/list")
    public List<ShopOwner> listAllShopOwners() {
        return shopOwnerService.listAll();
    }

    @PostMapping("/add")
    public void addShopOwner(@RequestBody ShopOwner shopOwner) {
        shopOwnerService.addShopOwner(shopOwner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopOwner> getShopOwnerById(@PathVariable Integer id) {
        try {
            ShopOwner shopOwner = shopOwnerService.get(id);
            return new ResponseEntity<>(shopOwner, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateShopOwner(@RequestBody ShopOwner shopOwner, @PathVariable Integer id) {
        try {
            ShopOwner existingShopOwner = shopOwnerService.get(id);
            shopOwner.setId(existingShopOwner.getId());
            shopOwnerService.updateShopOwner(shopOwner);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShopOwner(@PathVariable Integer id) {
        shopOwnerService.deleteShopOwner(id);
    }
}
