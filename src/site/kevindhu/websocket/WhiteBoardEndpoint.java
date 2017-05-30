package site.kevindhu.websocket;

import site.kevindhu.model.ChatEncoder;
import site.kevindhu.model.ChatMessage;
import site.kevindhu.model.FigureEncoder;
import site.kevindhu.model.Message;
import site.kevindhu.model.MessageDecoder;
import site.kevindhu.model.UserMessage;

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
        encoders = {FigureEncoder.class, ChatEncoder.class,},
        decoders = {MessageDecoder.class})

public class WhiteBoardEndpoint {
    public static Set<Session> peers = Collections.synchronizedSet(new HashSet<>());
    public static UserMessage users = new UserMessage();

    @OnMessage
    public void broadcastMessage(Message message, Session session) throws IOException, EncodeException {
        if (message instanceof ChatMessage) {
            ChatMessage chatMessage = (ChatMessage) message;
            String username = session.getUserProperties().get("username").toString();
            if (username != null) {
                chatMessage.setUsername(username);
            } else {
                chatMessage.setUsername(chatMessage.getMessage());
                session.getUserProperties().put("username",chatMessage.getUsername());
                chatMessage.setMessage("you are now" + chatMessage.getUsername());

                users.clients().add(chatMessage.getUsername());
                updateUsernames();
            }
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


    public void updateUsernames() throws IOException, EncodeException {
        for (Session peer : peers) {
            peer.getBasicRemote().sendObject(users);
        }
    }

}
