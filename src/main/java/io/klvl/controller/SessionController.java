package io.klvl.controller;

import io.klvl.model.Session;
import io.klvl.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings( "unused" )
@RestController
@RequestMapping( value = "/session" )
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping( value = "/create", method = RequestMethod.GET )
    public ResponseEntity<Session> create() {
        Session session = sessionService.createSession();
        return new ResponseEntity<>( session, HttpStatus.OK );
    }

}
