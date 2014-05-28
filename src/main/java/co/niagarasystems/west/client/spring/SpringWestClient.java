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
package co.niagarasystems.west.client.spring;

import org.springframework.messaging.Message;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;

import co.niagarasystems.west.client.IWestClient;
import co.niagarasystems.west.client.WestClientException;
import co.niagarasystems.west.io.SpringMessageCodec;

/**
 * Client implementation using Spring WebSocket.
 */
public class SpringWestClient implements IWestClient {

    private WebSocketSession session = null;


    /** Constructor */
    public SpringWestClient() { }


    public WebSocketSession getSession() {
        return session;
    }
    public void setSession(WebSocketSession session) {
        this.session = session;
    }


    @Override
    public void ping(String id) throws WestClientException {
        try {
            Message<?> msg = SpringMessageBuilder.pingMessage(id);
            session.sendMessage(new BinaryMessage(SpringMessageCodec.encode(msg)));
        }
        catch (Exception e) {
            throw new WestClientException(
                "PING command error.", e);
        }
    }

    @Override
    public void register(String id, String channel) throws WestClientException {
        try {
            Message<?> msg = SpringMessageBuilder.regMessage(id, channel);
            session.sendMessage(new BinaryMessage(SpringMessageCodec.encode(msg)));
        }
        catch (Exception e) {
            throw new WestClientException(
                "REGISTER command error.", e);
        }
    }

    @Override
    public void unregister(String id, String channel) throws WestClientException {
        try {
            Message<?> msg = SpringMessageBuilder.unregMessage(id, channel);
            session.sendMessage(new BinaryMessage(SpringMessageCodec.encode(msg)));
        }
        catch (Exception e) {
            throw new WestClientException(
                "UNREGISTER command error.", e);
        }
    }

    @Override
    public void send(String id, String channel, byte[] data) throws WestClientException {
        try {
            Message<?> msg = SpringMessageBuilder.sendMessage(id, channel, data);
            session.sendMessage(new BinaryMessage(SpringMessageCodec.encode(msg)));
        }
        catch (Exception e) {
            throw new WestClientException(
                "SEND command error.", e);
        }
    }

    @Override
    public void subscribe(String id, String channel) throws WestClientException {
        try {
            Message<?> msg = SpringMessageBuilder.subMessage(id, channel);
            session.sendMessage(new BinaryMessage(SpringMessageCodec.encode(msg)));
        }
        catch (Exception e) {
            throw new WestClientException(
                "SUBSCRIBE command error.", e);
        }
    }

    @Override
    public void unsubscribe(String id, String channel) throws WestClientException {
        try {
            Message<?> msg = SpringMessageBuilder.unsubMessage(id, channel);
            session.sendMessage(new BinaryMessage(SpringMessageCodec.encode(msg)));
        }
        catch (Exception e) {
            throw new WestClientException(
                "UNSUBSCRIBE command error.", e);
        }
    }

    @Override
    public void publish(String id, String channel, byte[] data) throws WestClientException {
        try {
            Message<?> msg = SpringMessageBuilder.pubMessage(id, channel, data);
            session.sendMessage(new BinaryMessage(SpringMessageCodec.encode(msg)));
        }
        catch (Exception e) {
            throw new WestClientException(
                "PUBLISH command error.", e);
        }
    }

}
