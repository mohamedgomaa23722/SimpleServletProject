package gov.iti.webSocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.protobuf.Message;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatSocket")
public class chatWebService {
    Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("created" + session.getQueryString());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("close");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println(message +  session.getOpenSessions().size());

        for (Session _session : session.getOpenSessions()) {
            _session.getBasicRemote().sendText(message);
        }
    }

    @OnError
    public void OnError(Throwable throwable){
        throwable.printStackTrace();
    }
}
