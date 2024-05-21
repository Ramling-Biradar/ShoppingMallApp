package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.entities.Mall;
import com.project.services.MallService;

import java.util.List;

@RestController
@RequestMapping("/malls")
public class MallController {

    @Autowired
    private MallService mallService;

    @GetMapping
    public List<Mall> getAllMalls() {
        return mallService.getAllMalls();
    }

    @GetMapping("/{id}")
    public Mall getMallById(@PathVariable Long id) {
        return mallService.getMallById(id);
    }

    @PostMapping
    public Mall createOrUpdateMall(@RequestBody Mall mall) {
        return mallService.createOrUpdateMall(mall);
    }
    @PutMapping("/{id}")
    public Mall updateMall(@PathVariable Long id, @RequestBody Mall updatedMall) {
        return mallService.updateMall(id, updatedMall);
    }

    @DeleteMapping("/{id}")
    public void deleteMall(@PathVariable Long id) {
        mallService.deleteMall(id);
    }
}
