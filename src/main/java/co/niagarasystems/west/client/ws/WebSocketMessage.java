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
package co.niagarasystems.west.client.ws;

import java.io.Serializable;

import co.niagarasystems.west.IMessage;
import co.niagarasystems.west.IWest;

/**
 * Defines a WebSocket Message.
 */
public class WebSocketMessage implements IMessage<byte[]>, Serializable {

    private static final long serialVersionUID = 5008105448662826415L;

    private String event = null;
    private String channel = null;
    private String from = null;
    private String id = null;
    private byte[] payload = null;


    @Override
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public WebSocketMessage withEvent(String event) {
        this.event = event;
        return this;
    }

    @Override
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public WebSocketMessage withChannel(String channel) {
        this.channel = channel;
        return this;
    }

    @Override
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public WebSocketMessage withFrom(String from) {
        this.from = from;
        return this;
    }

    @Override
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public WebSocketMessage withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public byte[] getPayload() {
        return payload;
    }
    public void setPayload(byte[] payload) {
        this.payload = payload;
    }
    public WebSocketMessage withPayload(byte[] payload) {
        this.payload = payload;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (event != null && !"".equals(event))
            sb.append("\"event\":\"").append(event).append("\", ");
        if (channel != null && !"".equals(channel))
            sb.append("\"channel\":\"").append(channel).append("\", ");
        if (from != null && !"".equals(from))
            sb.append("\"from\":\"").append(from).append("\", ");
        if (id != null && !"".equals(id))
            sb.append("\"id\":\"").append(id).append("\", ");
        if (payload != null) {
            if (IWest.IEvent.NEW_MESSAGE.equals(event)) {
                sb.append("\"payload\":\"").append(payload.toString()).append("\", ");
            } else {
                String pl = new String(payload);
                if (pl != null && !"".equals(pl))
                    sb.append("\"payload\":\"").append(pl).append("\", ");
            }
        }
        sb.delete(sb.toString().length() - 2, sb.toString().length()).append("}");
        return sb.toString();
    }

}
