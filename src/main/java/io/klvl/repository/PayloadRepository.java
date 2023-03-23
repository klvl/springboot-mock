package io.klvl.repository;

import io.klvl.model.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayloadRepository extends JpaRepository<Payload, Long> {
}
