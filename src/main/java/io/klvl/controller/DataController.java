package io.klvl.controller;

import io.klvl.model.Payload;
import io.klvl.model.Session;
import io.klvl.service.PayloadService;
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

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/data")
public class DataController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private PayloadService payloadService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<String> post(
            @RequestParam( "session_id" ) long sessionId,
            @Nullable @RequestHeader Map<String, String> headers,
            @Nullable @RequestBody String body
    ) {
        return receive(sessionId, body, headers, "/data/post", RequestMethod.POST);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<String> get(
            @RequestParam( "session_id" ) long sessionId,
            @Nullable @RequestHeader Map<String, String> headers,
            @Nullable @RequestBody String body
    ) {
        return receive(sessionId, body, headers, "/data/get", RequestMethod.GET);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(
            @RequestParam( "session_id" ) long sessionId,
            @Nullable @RequestHeader Map<String, String> headers,
            @Nullable @RequestBody String body
    ) {
        return receive(sessionId, body, headers, "/data/delete", RequestMethod.DELETE);
    }

    @RequestMapping(value = "/patch", method = RequestMethod.PATCH)
    public ResponseEntity<String> patch(
            @RequestParam( "session_id" ) long sessionId,
            @Nullable @RequestHeader Map<String, String> headers,
            @Nullable @RequestBody String body
    ) {
        return receive(sessionId, body, headers, "/data/patch", RequestMethod.PATCH);
    }

    private ResponseEntity<String> receive(
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
        Payload payload = new Payload( headers, body, endpoint, method);
        session.getPayload().add(payload);
        payloadService.save(payload);
        sessionService.save(session);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
