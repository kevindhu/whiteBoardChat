package site.kevindhu.websocket;

import site.kevindhu.model.Figure;
import site.kevindhu.model.FigureDecoder;
import site.kevindhu.model.FigureEncoder;
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
        decoders = {FigureDecoder.class})

public class WhiteBoardEndpoint {
    public static Set<Session> peers = Collections.synchronizedSet(new HashSet<>());

    @OnMessage
    public void broadcastMessage(Figure message, Session session) throws IOException, EncodeException {
        System.out.println("broadcastFigure: " + message);
        for (Session peer : peers) {
            if (!peer.equals(session)) {
                peer.getBasicRemote().sendObject(message);
            }
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

    //TODO: onError annotation

}
