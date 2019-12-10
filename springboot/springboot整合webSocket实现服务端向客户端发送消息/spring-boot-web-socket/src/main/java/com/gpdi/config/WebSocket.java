package com.gpdi.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
@Component
@ServerEndpoint(value = "/webSocket")
@Slf4j
public class WebSocket {
    //每个客户端都会有相应的session,服务端可以发送相关消息
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> copyOnWriteArraySet = new CopyOnWriteArraySet<WebSocket>();
    //存储userId和SessionId
    private Map<String, String> map = new ConcurrentHashMap<>();

    /**
     * 打开连接。进入页面后会自动发请求到此进行连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        String sessionUrl = session.getRequestURI().toString();
        String username = sessionUrl.substring(sessionUrl.indexOf("="), sessionUrl.length()).substring(1);
        map.put(username, session.getId());
        System.out.println("以下是最新的遍历结果");
        map.keySet().forEach((a) -> {
            System.out.println("用户为" + a + "用户的SessionID为" + map.get(a));
        });
        this.session = session;
        copyOnWriteArraySet.add(this);
        log.info("websocket有新的连接, 总数:" + copyOnWriteArraySet.size());
    }

    /**
     * 用户关闭页面，即关闭连接
     */
    @OnClose
    public void onClose() {
        copyOnWriteArraySet.remove(this);
        log.info("webSocket连接断开, 总数:" + copyOnWriteArraySet.size());
    }

    /**
     * 测试客户端发送消息，测试是否联通
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("websocket收到客户端发来的消息:" + message);
    }


    /**
     * 出现错误
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：" + error.getMessage(), session.getId());
        error.printStackTrace();
    }

    /**
     * 用于发送给客户端消息（群发）
     *
     * @param message
     */

    public void sendMessage(String message) {
        //遍历客户端
        for (WebSocket webSocket : copyOnWriteArraySet) {
            log.info("websocket广播消息：" + message);
            try {
                //服务器主动推送
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用于发送给指定客户端消息
     *
     * @param message
     */
    public void sendMessage(String sessionId, String message) throws IOException {
        //这里有一个Session,最外面还有一个全局Session
        Session session = null;
        WebSocket tempWebSocket = null;
        for (WebSocket webSocket : copyOnWriteArraySet) {
            if (webSocket.session.getId().equals(sessionId)) {
                tempWebSocket = webSocket;
                session = webSocket.session;
                break;
            }
        }
        if (session != null) {
            tempWebSocket.session.getBasicRemote().sendText(message);
        } else {
            log.warn("没有找到你指定ID的会话：{}", sessionId);
        }
    }

    /**
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }


}
