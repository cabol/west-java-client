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
import org.springframework.messaging.support.MessageBuilder;

import co.niagarasystems.west.IWest;

/**
 * Spring message builder.
 */
public final class SpringMessageBuilder {

    public static Message<?> pingMessage(String id) {
        Message<?> msg =
            MessageBuilder
                .withPayload("".getBytes())
                .setHeader(IWest.IHeader.EVENT, IWest.ICommand.PING)
                .setHeader(IWest.IHeader.ID, id)
                .build();
        return msg;
    }

    public static Message<?> regMessage(String id, String channel) {
        Message<?> msg =
            MessageBuilder
                .withPayload("".getBytes())
                .setHeader(IWest.IHeader.EVENT, IWest.ICommand.REGISTER)
                .setHeader(IWest.IHeader.CHANNEL, channel)
                .setHeader(IWest.IHeader.ID, id)
                .build();
        return msg;
    }

    public static Message<?> unregMessage(String id, String channel) {
        Message<?> msg =
            MessageBuilder
                .withPayload("".getBytes())
                .setHeader(IWest.IHeader.EVENT, IWest.ICommand.UNREGISTER)
                .setHeader(IWest.IHeader.CHANNEL, channel)
                .setHeader(IWest.IHeader.ID, id)
                .build();
        return msg;
    }

    public static Message<?> sendMessage(String id, String channel, byte[] data) {
        Message<?> msg =
            MessageBuilder
                .withPayload(data)
                .setHeader(IWest.IHeader.EVENT, IWest.ICommand.SEND)
                .setHeader(IWest.IHeader.CHANNEL, channel)
                .setHeader(IWest.IHeader.ID, id)
                .build();
        return msg;
    }

    public static Message<?> subMessage(String id, String channel) {
        Message<?> msg =
            MessageBuilder
                .withPayload("".getBytes())
                .setHeader(IWest.IHeader.EVENT, IWest.ICommand.SUBSCRIBE)
                .setHeader(IWest.IHeader.CHANNEL, channel)
                .setHeader(IWest.IHeader.ID, id)
                .build();
        return msg;
    }

    public static Message<?> unsubMessage(String id, String channel) {
        Message<?> msg =
            MessageBuilder
                .withPayload("".getBytes())
                .setHeader(IWest.IHeader.EVENT, IWest.ICommand.UNSUBSCRIBE)
                .setHeader(IWest.IHeader.CHANNEL, channel)
                .setHeader(IWest.IHeader.ID, id)
                .build();
        return msg;
    }

    public static Message<?> pubMessage(String id, String channel, byte[] data) {
        Message<?> msg =
            MessageBuilder
                .withPayload(data)
                .setHeader(IWest.IHeader.EVENT, IWest.ICommand.PUBLISH)
                .setHeader(IWest.IHeader.CHANNEL, channel)
                .setHeader(IWest.IHeader.ID, id)
                .build();
        return msg;
    }

}
