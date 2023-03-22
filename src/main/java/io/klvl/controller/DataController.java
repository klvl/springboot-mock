package io.klvl.controller;

import io.klvl.model.Payload;
import io.klvl.model.Session;
import io.klvl.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/data")
public class DataController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity post(
            @RequestParam( "session_id" ) long sessionId,
            @RequestHeader Map<String, String> headers,
            @Nullable @RequestBody String body
    ) {
        return receive(sessionId, body, headers, "/data/post", RequestMethod.POST);
    }

    private ResponseEntity receive(
            long sessionId,
            String body,
            Map<String, String> headers,
            String endpoint,
            RequestMethod method
    ) {
        body = body == null ? "" : body;
        if (!sessionService.isSessionExist(sessionId)) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Session session = sessionService.findSession(sessionId);
        session.getPayload().add(
                new Payload( headers, body, endpoint, method)
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
