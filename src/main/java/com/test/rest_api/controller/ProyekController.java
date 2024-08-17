package com.test.rest_api.controller;

import com.test.rest_api.model.Proyek;
import com.test.rest_api.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {
    @Autowired
    private ProyekService proyekService;

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekService.getAllProyek();
    }

    @PostMapping
    public Proyek createProyek(@RequestBody Proyek proyek) {
        return proyekService.saveProyek(proyek);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyek) {
        Proyek updatedProyek = proyekService.updateProyek(id, proyek);
        if (updatedProyek != null) {
            return ResponseEntity.ok(updatedProyek);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
        proyekService.deleteProyek(id);
        return ResponseEntity.noContent().build();
    }
}