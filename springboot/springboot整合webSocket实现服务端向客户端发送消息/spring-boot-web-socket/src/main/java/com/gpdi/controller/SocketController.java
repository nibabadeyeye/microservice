package com.gpdi.controller;

import com.gpdi.config.WebSocket;
import com.gpdi.util.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.io.IOException;



/**
 * @desc: 用Socket实现服务端到客户端消息的单发和群发
 */
@Controller
public class SocketController {

    /**
     * @desc: 向所有人发送消息
     */
    @RequestMapping("sendToAll")
    @ResponseBody
    public ResponseData sendToAll() {

        webSocket.sendMessage("服务端向客户端消息群发！");
        return new ResponseData(200, "群发请求成功");

    }

    /**
     * @desc: 向某个人发送消息
     */
    @RequestMapping("sendToOne")
    @ResponseBody
    public ResponseData sendToOne(String sessionId) throws IOException {
        webSocket.sendMessage(sessionId, "向SessionId为" + sessionId + "的用户发送消息通知");
        return new ResponseData(200, "单发请求成功", sessionId);
    }

    @Resource
    WebSocket webSocket;

}