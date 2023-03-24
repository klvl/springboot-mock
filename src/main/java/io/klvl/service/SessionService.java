package io.klvl.service;

import io.klvl.common.SessionNotFoundException;
import io.klvl.model.Session;
import io.klvl.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
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

    public Session findSession(long sessionId) {
        return sessionRepository
                .findBySessionId(sessionId)
                .orElseThrow( () -> new SessionNotFoundException("Session with id " + sessionId + " was not found!"));
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isSessionExist(long sessionId) {
        try {
            findSession(sessionId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void save(Session session) {
        sessionRepository.save(session);
    }

}
