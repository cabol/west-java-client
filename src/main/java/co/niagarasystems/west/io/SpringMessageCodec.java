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
package co.niagarasystems.west.io;

import java.io.IOException;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import co.niagarasystems.west.IWest;
import co.niagarasystems.west.pb.MessageProtos;
import co.niagarasystems.west.pb.MessageProtos.Message.Builder;

import com.google.protobuf.ByteString;

/**
 * Spring {@link Message} codec facilities. Provides methods to encode
 * from Spring Message to WEST protobuff message (binary) and decode
 * from potobuff to Spring Message.
 */
public class SpringMessageCodec {

    /**
     * Encodes the given Spring message to a byte array, that is the
     * binary representation of a Protobuff message.
     *
     * @param message
     *          Spring message.
     * @return
     *          Byte array, representation of a {@link MessageProtos.Message}.
     * @throws IOException
     *          When any error occurs encoding the message.
     */
    public static byte[] encode(Message<?> message) throws IOException {
        Builder msgBuilder = MessageProtos.Message.newBuilder();
        String event = message.getHeaders().get(IWest.IHeader.EVENT, String.class);
        String channel = message.getHeaders().get(IWest.IHeader.CHANNEL, String.class);
        String from = message.getHeaders().get(IWest.IHeader.FROM, String.class);
        String id = message.getHeaders().get(IWest.IHeader.ID, String.class);
        byte[] payload = CodecUtils.encode(message.getPayload());

        if (event != null && !"".equals(event))
            msgBuilder.setEvent(event);
        if (channel != null && !"".equals(channel))
            msgBuilder.setChannel(channel);
        if (from != null && !"".equals(from))
            msgBuilder.setFrom(from);
        if (id != null && !"".equals(id))
            msgBuilder.setId(id);
        if (payload != null)
            msgBuilder.setData(ByteString.copyFrom(payload));

        return msgBuilder.build().toByteArray();
    }

    /**
     * Decodes the given byte array from Protobuff to Spring message.
     *
     * @param data
     *          Byte array, representation of a {@link MessageProtos.Message}.
     * @return
     *          Spring message.
     * @throws IOException
     *          When any error occurs decoding the message.
     */
    public static Message<?> decode(byte[] data) throws IOException {
        MessageProtos.Message decMsg =
            MessageProtos.Message.parseFrom(data);
        Message<?> message =
            MessageBuilder
                .withPayload(decMsg.getData().toByteArray())
                .setHeader(IWest.IHeader.EVENT, decMsg.getEvent())
                .setHeader(IWest.IHeader.CHANNEL, decMsg.getChannel())
                .setHeader(IWest.IHeader.FROM, decMsg.getFrom())
                .setHeader(IWest.IHeader.ID, decMsg.getId())
                .build();
        return message;
    }

}
