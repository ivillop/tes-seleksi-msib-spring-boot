package com.test.rest_api.repository;

import com.test.rest_api.model.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekRepository extends JpaRepository<Proyek, Long> {
}
