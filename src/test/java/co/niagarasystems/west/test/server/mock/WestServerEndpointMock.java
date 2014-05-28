/*
 * Copyright 2014 Niagara Systems Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.niagarasystems.west.test.server.mock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import co.niagarasystems.west.IWest;
import co.niagarasystems.west.client.ws.WebSocketMessage;
import co.niagarasystems.west.client.ws.WebSocketMessageCodec;

/**
 * WEST Server Endpoint Mock.
 */
@ServerEndpoint(value = "/west/{key}",
                encoders = {WebSocketMessageCodec.MessageEncoder.class},
                decoders = {WebSocketMessageCodec.MessageDecoder.class})
public class WestServerEndpointMock {

    // Client key (identifier)
    private String clientKey = null;

    // Event store
    private Map<String, String> dict = new ConcurrentHashMap<String, String>();


    @OnOpen
    public void onOpen(
            @PathParam("key") final String key,
            final Session session) throws Exception {
        clientKey = key;
        session.getBasicRemote().sendObject(
            new WebSocketMessage()
                .withEvent(IWest.IEvent.CONNECTION_ESTABLISHED));
    }

    @OnClose
    public void onClose(final Session session) {
        // Nothing to do
    }

    @OnMessage
    public void onMessage(
            final WebSocketMessage message,
            final Session client) throws Exception {
        String event = message.getEvent();
        String outEvent = null;
        switch (event) {
        case IWest.ICommand.PING:
            client.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.IEvent.PONG)
                    .withId(message.getId()));
            break;
        case IWest.ICommand.REGISTER:
            if (dict.containsKey(message.getChannel())) {
                outEvent = IWest.IEvent.REGISTRATION_ALREADY_EXIST;
            }
            else {
                dict.put(message.getChannel(), message.getChannel());
                outEvent = IWest.IEvent.REGISTRATION_SUCCEEDED;
            }
            client.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(outEvent)
                    .withChannel(message.getChannel())
                    .withId(message.getId()));
            break;
        case IWest.ICommand.UNREGISTER:
            if (dict.containsKey(message.getChannel())) {
                dict.remove(message.getChannel());
                outEvent = IWest.IEvent.UNREGISTRATION_SUCCEEDED;
            }
            else {
                outEvent = IWest.IEvent.REGISTRATION_NOT_FOUND;
            }
            client.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(outEvent)
                    .withChannel(message.getChannel())
                    .withId(message.getId()));
            break;
        case IWest.ICommand.SEND:
            outEvent = dict.containsKey(message.getChannel()) ?
                IWest.IEvent.SENDING_SUCCEEDED : IWest.IEvent.REGISTRATION_NOT_FOUND;
            client.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(outEvent)
                    .withChannel(message.getChannel())
                    .withId(message.getId()));
            if (IWest.IEvent.SENDING_SUCCEEDED.equals(outEvent)) {
                Thread.sleep(100);
                client.getBasicRemote().sendObject(
                    new WebSocketMessage()
                        .withEvent(IWest.IEvent.NEW_MESSAGE)
                        .withChannel(message.getChannel())
                        .withFrom(clientKey)
                        .withId(String.format("client-%s", message.getId()))
                        .withPayload(message.getPayload()));
            }
            break;
        case IWest.ICommand.SUBSCRIBE:
            if (dict.containsKey(message.getChannel())) {
                outEvent = IWest.IEvent.SUBSCRIPTION_ALREADY_EXIST;
            }
            else {
                dict.put(message.getChannel(), message.getChannel());
                outEvent = IWest.IEvent.SUBSCRIPTION_SUCCEEDED;
            }
            client.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(outEvent)
                    .withChannel(message.getChannel())
                    .withId(message.getId()));
            break;
        case IWest.ICommand.UNSUBSCRIBE:
            if (dict.containsKey(message.getChannel())) {
                dict.remove(message.getChannel());
                outEvent = IWest.IEvent.UNSUBSCRIPTION_SUCCEEDED;
            }
            else {
                outEvent = IWest.IEvent.SUBSCRIPTION_NOT_FOUND;
            }
            client.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(outEvent)
                    .withChannel(message.getChannel())
                    .withId(message.getId()));
            break;
        case IWest.ICommand.PUBLISH:
            outEvent = dict.containsKey(message.getChannel()) ?
                IWest.IEvent.PUBLICATION_SUCCEEDED : IWest.IEvent.PUBLICATION_FAILED;
            client.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(outEvent)
                    .withChannel(message.getChannel())
                    .withId(message.getId()));
            if (IWest.IEvent.PUBLICATION_SUCCEEDED.equals(outEvent)) {
                Thread.sleep(100);
                client.getBasicRemote().sendObject(
                    new WebSocketMessage()
                        .withEvent(IWest.IEvent.NEW_MESSAGE)
                        .withChannel(message.getChannel())
                        .withFrom(clientKey)
                        .withId(String.format("client-%s", message.getId()))
                        .withPayload(message.getPayload()));
            }
            break;
        }
    }


    public Map<String, String> getDict() {
        return dict;
    }
    public void setDict(Map<String, String> dict) {
        this.dict = dict;
    }

}
