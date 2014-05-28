package co.niagarasystems.west.test.spring;

import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.web.socket.WebSocketSession;

import co.niagarasystems.west.IWest;
import co.niagarasystems.west.client.spring.WestProtobuffsWebSocketHandler;
import co.niagarasystems.west.io.CodecUtils;
import co.niagarasystems.west.test.Account;

public class MyHandler extends WestProtobuffsWebSocketHandler {

    private Map<String, String> events;


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("----- CONNECTION ESTABLISHED -----");
    }

    @Override
    public void handleProtobuffsMessage(WebSocketSession session, Message<?> message) throws Exception {
        System.out.println(MyHandler.class.getName() + ": " + message);

        // Store the event
        String id = message.getHeaders().get(IWest.IHeader.ID, String.class);
        if (id != null && !"".equals(id))
            events.put(id, message.getHeaders().get(IWest.IHeader.EVENT, String.class));

        if (IWest.IEvent.NEW_MESSAGE.equals(message.getHeaders().get(IWest.IHeader.EVENT, String.class))) {
            String channel = (String) message.getHeaders().get(IWest.IHeader.CHANNEL);
            if ("strings".equals(channel)) {
                String payload = CodecUtils.decode((byte[]) message.getPayload(), String.class);
                System.out.println(">> PAYLOAD: " + payload);
            }
            else if ("accounts".equals(channel)) {
                Account account = CodecUtils.decode((byte[]) message.getPayload(), Account.class);
                System.out.println(">> ACCOUNT: " + account);
            }
        }
    }


    public Map<String, String> getEvents() {
        return events;
    }
    public void setEvents(Map<String, String> events) {
        this.events = events;
    }

}
