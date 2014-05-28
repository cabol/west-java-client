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

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import co.niagarasystems.west.pb.MessageProtos;
import co.niagarasystems.west.pb.MessageProtos.Message.Builder;

import com.google.protobuf.ByteString;

/**
 * Wraps the WebSocket message codecs (Encoder and Decoder).
 * This class is in charge of serialize and deserialize binary data.
 */
public class WebSocketMessageCodec {

    /**
     * Defines Encoder.
     */
    public static class MessageEncoder implements Encoder.Binary<WebSocketMessage> {

        @Override
        public void init(final EndpointConfig config) { }

        @Override
        public ByteBuffer encode(WebSocketMessage msg) throws EncodeException {
            Builder msgBuilder = MessageProtos.Message.newBuilder();
            if (msg.getEvent() != null && !"".equals(msg.getEvent()))
                msgBuilder.setEvent(msg.getEvent().toString());
            if (msg.getChannel() != null && !"".equals(msg.getChannel()))
                msgBuilder.setChannel(msg.getChannel());
            if (msg.getFrom() != null && !"".equals(msg.getFrom()))
                msgBuilder.setFrom(msg.getFrom());
            if (msg.getId() != null && !"".equals(msg.getId()))
                msgBuilder.setId(msg.getId());
            if (msg.getPayload() != null)
                msgBuilder.setData(ByteString.copyFrom(msg.getPayload()));

            return ByteBuffer.wrap(msgBuilder.build().toByteArray());
        }

        @Override
        public void destroy() { }

    }

    /**
     * Defines Decoder.
     */
    public static class MessageDecoder implements Decoder.Binary<WebSocketMessage> {

        @Override
        public void init(final EndpointConfig config) { }

        @Override
        public WebSocketMessage decode(ByteBuffer buffer) throws DecodeException {
            try {
                MessageProtos.Message decMsg =
                    MessageProtos.Message.parseFrom(buffer.array());
                WebSocketMessage msg = new WebSocketMessage()
                    .withEvent(decMsg.getEvent())
                    .withChannel(decMsg.getChannel())
                    .withFrom(decMsg.getFrom())
                    .withId(decMsg.getId())
                    .withPayload(decMsg.getData().toByteArray());
                return msg;
            }
            catch (IOException e) {
                throw new DecodeException(buffer, "Error parsing buffer.", e);
            }
        }

        @Override
        public boolean willDecode(ByteBuffer arg0) {
            return true;
        }

        @Override
        public void destroy() { }

    }

}
