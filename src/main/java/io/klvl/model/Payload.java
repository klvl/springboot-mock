package io.klvl.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Table
@Data
public class Payload {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String headers;

    @Column
    private String payload;

    @Column
    private String endpoint;

    @Column
    private String method;

    @Column
    private String time;

    @SuppressWarnings("unused")
    public Payload() {
    }

    public Payload(Map<String, String> headers, String payload, String endpoint, RequestMethod method) {
        this.setHeaders(headersToString(headers));
        this.setPayload(payload);
        this.setEndpoint(endpoint);
        this.setMethod(method.name());
        this.setTime(getPayloadTime());
    }

    private String headersToString(Map<String, String> headers) {
        return headers.keySet()
                .stream()
                .map( key -> key + "=" + headers.get(key))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private String getPayloadTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return formatter.format(LocalDateTime.now());
    }

}
