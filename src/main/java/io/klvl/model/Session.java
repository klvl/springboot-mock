package io.klvl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Set;

@Entity
@Table
@Data
public class Session {

    @Id
    @GeneratedValue
    private Long id;

    private long sessionId;

    private HttpStatus httpStatus;

    @OneToMany(orphanRemoval = true)
    private Set<Payload> payload;

}
