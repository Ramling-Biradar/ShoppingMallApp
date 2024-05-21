package com.project.controllers;

import com.project.entities.Shop;
import com.project.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/list")
    public List<Shop> listAllShops() {
        return shopService.listAll();
    }

    @PostMapping("/add")
    public void addShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Integer id) {
        try {
            Shop shop = shopService.get(id);
            return new ResponseEntity<>(shop, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateShop(@RequestBody Shop shop, @PathVariable Integer id) {
        try {
            Shop existingShop = shopService.get(id);
            shop.setShopId(existingShop.getShopId());
            shopService.updateShop(shop);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShop(@PathVariable Integer id) {
        shopService.deleteShop(id);
    }
}
