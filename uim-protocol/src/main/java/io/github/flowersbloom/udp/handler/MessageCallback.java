package io.github.flowersbloom.udp.handler;

import io.github.flowersbloom.udp.packet.BasePacket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 消息回调
 */
public interface MessageCallback {
    List<MessageListener> listenerList = Collections.synchronizedList(new ArrayList<>());

    public static void subscribe(MessageListener listener) {
        listenerList.add(listener);
    }

    public static void unsubscribe(MessageListener listener) {
        listenerList.remove(listener);
    }

    public default void notice(BasePacket basePacket) {
        for (MessageListener listener : listenerList) {
            listener.handle(basePacket);
        }
    }
}
