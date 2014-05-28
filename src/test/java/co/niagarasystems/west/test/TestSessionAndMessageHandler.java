package co.niagarasystems.west.test;

import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.Session;

import co.niagarasystems.west.IMessage;
import co.niagarasystems.west.IWest;
import co.niagarasystems.west.client.ws.IWebSocketSessionAwareMessageHandler;
import co.niagarasystems.west.client.ws.WebSocketMessage;
import co.niagarasystems.west.io.CodecUtils;

public class TestSessionAndMessageHandler implements IWebSocketSessionAwareMessageHandler {

    private Map<String, String> events;


    @Override
    public void handle(IMessage<?> message) throws Exception {
        System.out.println(">> NEW MESSAGE: " + message.toString());

        // Store the event
        if (message.getId() != null && !"".equals(message.getId()))
            events.put(message.getId(), message.getEvent());

        if (IWest.IEvent.NEW_MESSAGE.equals(message.getEvent())) {
            if ("strings".equals(message.getChannel())) {
                String payload = CodecUtils.decode((byte[]) message.getPayload(), String.class);
                System.out.println(">> PAYLOAD: " + payload);
            }
            else if ("accounts".equals(message.getChannel())) {
                Account account = CodecUtils.decode((byte[]) message.getPayload(), Account.class);
                System.out.println(">> ACCOUNT: " + account);
            }
        }
    }

    @Override
    public void handleOpen(final Session session) {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.PING)
                    .withId("1234"));
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void handleClose(
            final Session session,
            final CloseReason closeReason) {
        System.out.println(
            ">> Connection closed: " + closeReason.getCloseCode().toString());
    }

    @Override
    public void handleError(final Session session, final Throwable e) {
        e.printStackTrace();
    }


    public Map<String, String> getEvents() {
        return events;
    }
    public void setEvents(Map<String, String> events) {
        this.events = events;
    }

}
