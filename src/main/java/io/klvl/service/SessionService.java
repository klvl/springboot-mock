package io.klvl.service;

import io.klvl.model.Session;
import io.klvl.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession() {
        Session session = new Session();
        session.setSessionId(System.currentTimeMillis());
        sessionRepository.save(session);
        return session;
    }

}
