/* package br.com.fatec.springbootpi.service;

import java.net.http.WebSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("websocket/{shopId}")
public class WebSocketService {
    private Session session;
    
    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();
    
    @OnOpen
    public void onOpen(Session session, @PathParam(value="shopId")String shopId) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(shopId, session);
        System.out.println ("[websocket message] has new connections, total:"+webSockets.size());
    }
    
    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System. out. println ("[websocket message] disconnected, total:"+webSockets.size());
    }
    
    @OnMessage
    public void onMessage(String message) {
        System.out.println ("[websocket message] receives client message:"+message);
    }
    
    // This is a broadcast message.
    public void sendAllMessage(String message) {
        for(WebSocket webSocket : webSockets) {
            System.out.println ("[websocket message] broadcast message:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // This is a single message
    public void sendOneMessage(String shopId, String message) {
        Session session = sessionPool.get(shopId);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }   
} */