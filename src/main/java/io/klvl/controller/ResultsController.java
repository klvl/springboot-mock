package io.klvl.controller;

import io.klvl.model.Payload;
import io.klvl.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;

@RestController
@RequestMapping(value = "{session_id}/results")
public class ResultsController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ResponseEntity resultData(@PathVariable( "session_id" ) long sessionId) {
        if (!sessionService.isSessionExist(sessionId)) {
            return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(
                sessionService.findSession(sessionId)
                        .getPayload()
                        .stream()
                        .sorted( Comparator.comparing(Payload::getId)),
                HttpStatus.OK
        );
    }
}
