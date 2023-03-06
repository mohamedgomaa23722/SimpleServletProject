package gov.iti.webSocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class chatWebService {
    Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        for (Session _session : sessions) {
            _session.getBasicRemote().sendText(message);
        }
    }
}
