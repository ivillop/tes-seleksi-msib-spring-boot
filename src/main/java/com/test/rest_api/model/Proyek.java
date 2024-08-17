package com.test.rest_api.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_proyek", nullable = false)
    private String namaProyek;

    @Column(nullable = false)
    private String client;

    @Column(name = "tgl_mulai", nullable = false)
    private LocalDate tglMulai;

    @Column(name = "tgl_selesai")
    private LocalDate tglSelesai;

    @Column(name = "pimpinan_proyek", nullable = false)
    private String pimpinanProyek;

    private String keterangan;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt = LocalDate.now();

    @ManyToMany
    @JoinTable(
            name = "proyek_lokasi",
            joinColumns = @JoinColumn(name = "proyek_id"),
            inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private Set<Lokasi> lokasi;

    // Getter dan Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(LocalDate tglMulai) {
        this.tglMulai = tglMulai;
    }

    public LocalDate getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(LocalDate tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Lokasi> getLokasi() {
        return lokasi;
    }

    public void setLokasi(Set<Lokasi> lokasi) {
        this.lokasi = lokasi;
    }
}
