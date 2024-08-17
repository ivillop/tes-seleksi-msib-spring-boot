package com.test.rest_api.controller;

import com.test.rest_api.model.Lokasi;
import com.test.rest_api.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    private LokasiService lokasiService;

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.getAllLokasi();
    }

    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.saveLokasi(lokasi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasi) {
        Lokasi updatedLokasi = lokasiService.updateLokasi(id, lokasi);
        if (updatedLokasi != null) {
            return ResponseEntity.ok(updatedLokasi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Long id) {
        lokasiService.deleteLokasi(id);
        return ResponseEntity.noContent().build();
    }
}