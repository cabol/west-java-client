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
package co.niagarasystems.west.utils;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import co.niagarasystems.west.IMessage;
import co.niagarasystems.west.IWest;
import co.niagarasystems.west.client.ws.WebSocketMessage;

/**
 * Common utilities for messages.
 */
public class MessageUtils {

    public static IMessage<?> toWestMessage(Message<?> msg) {
        WebSocketMessage newMsg =
            new WebSocketMessage()
                .withEvent(msg.getHeaders().get(IWest.IHeader.EVENT, String.class))
                .withChannel(msg.getHeaders().get(IWest.IHeader.CHANNEL, String.class))
                .withChannel(msg.getHeaders().get(IWest.IHeader.FROM, String.class))
                .withChannel(msg.getHeaders().get(IWest.IHeader.ID, String.class))
                .withPayload((byte[]) msg.getPayload());
        return newMsg;
    }

    public static Message<?> toSpringMessage(IMessage<?> msg) {
        Message<?> newMsg =
            MessageBuilder
                .withPayload(msg.getPayload())
                .setHeader(IWest.IHeader.EVENT, msg.getEvent())
                .setHeader(IWest.IHeader.CHANNEL, msg.getChannel())
                .setHeader(IWest.IHeader.FROM, msg.getFrom())
                .setHeader(IWest.IHeader.ID, msg.getId())
                .build();
        return newMsg;
    }

}
