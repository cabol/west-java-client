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
package co.niagarasystems.west.client.support;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import co.niagarasystems.west.IWest;
import co.niagarasystems.west.client.IWestClient;
import co.niagarasystems.west.client.WestClientException;
import co.niagarasystems.west.client.ws.WebSocketClientHandler;
import co.niagarasystems.west.client.ws.WebSocketMessage;

/**
 * Default implementation of the WEST Client.
 */
public class DefaultWestClient implements IWestClient {

    private final WebSocketContainer container =
        ContainerProvider.getWebSocketContainer();

    private Session session = null;


    /** Constructor */
    public DefaultWestClient() { }

    /** Constructor */
    public DefaultWestClient(
            WebSocketClientHandler wsClientHandler, String uri)
            throws WestClientException {
        try {
            session =
                container.connectToServer(wsClientHandler, URI.create(uri));
        }
        catch (Exception e) {
            throw new WestClientException(
                "Error initializing WebSocket connection.", e);
        }
    }


    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }


    @Override
    public void ping(String id) throws WestClientException {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.PING)
                    .withId(id));
        }
        catch (Exception e) {
            throw new WestClientException(
                "PING command error.", e);
        }
    }

    @Override
    public void register(String id, String channel)
            throws WestClientException {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.REGISTER)
                    .withChannel(channel)
                    .withId(id));
        }
        catch (Exception e) {
            throw new WestClientException(
                "REGISTER command error.", e);
        }
    }

    @Override
    public void unregister(String id, String channel)
            throws WestClientException {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.UNREGISTER)
                    .withChannel(channel)
                    .withId(id));
        }
        catch (Exception e) {
            throw new WestClientException(
                "UNREGISTER command error.", e);
        }
    }

    @Override
    public void send(String id, String channel, byte[] data)
            throws WestClientException {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.SEND)
                    .withChannel(channel)
                    .withId(id)
                    .withPayload(data));
        }
        catch (Exception e) {
            throw new WestClientException(
                "SEND command error.", e);
        }
    }

    @Override
    public void subscribe(String id, String channel)
            throws WestClientException {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.SUBSCRIBE)
                    .withChannel(channel)
                    .withId(id));
        }
        catch (Exception e) {
            throw new WestClientException(
                "SUBSCRIBE command error.", e);
        }
    }

    @Override
    public void unsubscribe(String id, String channel)
            throws WestClientException {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.UNSUBSCRIBE)
                    .withChannel(channel)
                    .withId(id));
        }
        catch (Exception e) {
            throw new WestClientException(
                "UNSUBSCRIBE command error.", e);
        }
    }

    @Override
    public void publish(String id, String channel, byte[] data)
            throws WestClientException {
        try {
            session.getBasicRemote().sendObject(
                new WebSocketMessage()
                    .withEvent(IWest.ICommand.PUBLISH)
                    .withChannel(channel)
                    .withId(id)
                    .withPayload(data));
        }
        catch (Exception e) {
            throw new WestClientException(
                "PUBLISH command error.", e);
        }
    }

}
