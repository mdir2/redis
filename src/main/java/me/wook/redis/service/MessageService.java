package me.wook.redis.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements MessageListener {

    public static List<String> messages = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        messages.add(message.toString());
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        System.out.println("Message received: " + message.toString());
    }
}
