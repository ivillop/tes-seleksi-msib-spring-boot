package com.test.rest_api.service;

import com.test.rest_api.model.Lokasi;
import com.test.rest_api.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Lokasi getLokasiById(Long id) {
        return lokasiRepository.findById(id).orElse(null);
    }

    public Lokasi saveLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public Lokasi updateLokasi(Long id, Lokasi lokasi) {
        Lokasi existingLokasi = lokasiRepository.findById(id).orElse(null);
        if (existingLokasi != null) {
            existingLokasi.setNamaLokasi(lokasi.getNamaLokasi());
            existingLokasi.setNegara(lokasi.getNegara());
            existingLokasi.setProvinsi(lokasi.getProvinsi());
            existingLokasi.setKota(lokasi.getKota());
            return lokasiRepository.save(existingLokasi);
        }
        return null;
    }

    public void deleteLokasi(Long id) {
        lokasiRepository.deleteById(id);
    }
}