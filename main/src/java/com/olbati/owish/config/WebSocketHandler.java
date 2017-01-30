package com.olbati.owish.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

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
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println(" session  connected is " + session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        System.out.println(jsonTextMessage);
    }
}
