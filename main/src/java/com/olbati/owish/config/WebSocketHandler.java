package com.olbati.owish.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 30/01/2017.
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {


    private List<WebSocketSession> sessions = new ArrayList();

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {

    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println(" session  connected is " + session.getId());

    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        sessions.forEach((s) -> {
            try {
                s.sendMessage(new TextMessage("update_List"));
                System.out.println("message was send to " + s.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
