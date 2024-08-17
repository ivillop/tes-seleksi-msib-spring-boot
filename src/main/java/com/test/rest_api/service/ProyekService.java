package com.test.rest_api.service;

import com.test.rest_api.model.Proyek;
import com.test.rest_api.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProyekService {
    @Autowired
    private ProyekRepository proyekRepository;

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Proyek getProyekById(Long id) {
        return proyekRepository.findById(id).orElse(null);
    }

    public Proyek saveProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public Proyek updateProyek(Long id, Proyek proyek) {
        Proyek existingProyek = proyekRepository.findById(id).orElse(null);
        if (existingProyek != null) {
            existingProyek.setNamaProyek(proyek.getNamaProyek());
            existingProyek.setClient(proyek.getClient());
            existingProyek.setTglMulai(proyek.getTglMulai());
            existingProyek.setTglSelesai(proyek.getTglSelesai());
            existingProyek.setPimpinanProyek(proyek.getPimpinanProyek());
            existingProyek.setKeterangan(proyek.getKeterangan());
            existingProyek.setLokasi(proyek.getLokasi());
            return proyekRepository.save(existingProyek);
        }
        return null;
    }

    public void deleteProyek(Long id) {
        proyekRepository.deleteById(id);
    }
}