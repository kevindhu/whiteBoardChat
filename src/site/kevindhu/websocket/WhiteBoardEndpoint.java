package site.kevindhu.websocket;

import site.kevindhu.model.ChatMessage;
import site.kevindhu.model.FigureEncoder;
import site.kevindhu.model.Message;
import site.kevindhu.model.MessageDecoder;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/whiteboardendpoint",
        encoders = {FigureEncoder.class},
        decoders = {MessageDecoder.class})

public class WhiteBoardEndpoint {
    public static Set<Session> peers = Collections.synchronizedSet(new HashSet<>());

    @OnMessage
    public void broadcastMessage(Message message, Session session) throws IOException, EncodeException {
        if (message instanceof ChatMessage) {
            String username = session.getUserProperties().get("username").toString();

        }
        for (Session peer : peers) {
            peer.getBasicRemote().sendObject(message);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        peers.remove(session);
    }


    public Set<String> getUsernames() {
        Set<String> ret = new HashSet<>();
        for (Session peer : peers) {
            ret.add(peer.getUserProperties().get("username").toString());
        }
        return ret;
    }

}
