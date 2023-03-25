package io.klvl.repository;

import io.klvl.model.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings( "unused" )
public interface PayloadRepository extends JpaRepository<Payload, Long> {
}
