package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.entities.MallAdmin;
import com.project.services.MallAdminService;

import java.util.List;

@RestController
@RequestMapping("/mallAdmins")
public class MallAdminController {

    @Autowired
    private MallAdminService mallAdminService;

    @GetMapping
    public List<MallAdmin> getAllMallAdmins() {
        return mallAdminService.getAllMallAdmins();
    }

    @GetMapping("/{id}")
    public MallAdmin getMallAdminById(@PathVariable int id) {
        return mallAdminService.getMallAdminById(id);
    }

    @PostMapping
    public MallAdmin createOrUpdateMallAdmin(@RequestBody MallAdmin mallAdmin) {
        return mallAdminService.createOrUpdateMallAdmin(mallAdmin);
    }

    @DeleteMapping("/{id}")
    public void deleteMallAdmin(@PathVariable int id) {
        mallAdminService.deleteMallAdmin(id);
    }
}

