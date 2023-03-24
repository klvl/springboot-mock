package io.klvl.service;

import io.klvl.model.Payload;
import io.klvl.repository.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings({"UnusedReturnValue", "unused"})
@Service
public class PayloadService {

    @Autowired
    private PayloadRepository payloadRepository;

    public Payload save(Payload payload) {
        return payloadRepository.save(payload);
    }

}
