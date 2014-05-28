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

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import co.niagarasystems.west.IMessageHandler;

/**
 * Handles WebSocket events.
 */
@ClientEndpoint(encoders = {WebSocketMessageCodec.MessageEncoder.class},
                decoders = {WebSocketMessageCodec.MessageDecoder.class})
public class WebSocketClientHandler {

    // Logger
    private static final Logger log =
        Logger.getLogger(WebSocketClientHandler.class.getName());

    // Handlers
    private IMessageHandler handler = null;


    /** Constructor */
    public WebSocketClientHandler() { }

    /** Constructor */
    public WebSocketClientHandler(IMessageHandler handler) {
        this.handler = handler;
    }


    @OnOpen
    public void onOpen(final Session session) throws Exception {
        if (log.isDebugEnabled())
            log.debug(String.format("WebSocket Client connected!\n"));
        if (handler != null && handler instanceof IWebSocketSessionAwareMessageHandler)
            ((IWebSocketSessionAwareMessageHandler) handler).handleOpen(session);
    }

    @OnMessage
    public void onMessage(final WebSocketMessage message) throws Exception {
        if (log.isDebugEnabled())
            log.debug(String.format("Message: %s\n", message.toString()));
        if (handler != null)
            handler.handle(message);
    }

    @OnClose
    public void onClose(final Session session, final CloseReason reason) throws Exception {
        if (log.isDebugEnabled())
            log.debug(String.format(
                "WebSocket Client closed: %s\n", reason.getReasonPhrase()));
        if (handler != null && handler instanceof IWebSocketSessionAwareMessageHandler)
            ((IWebSocketSessionAwareMessageHandler) handler).handleClose(session, reason);
    }

    @OnError
    public void onError(final Session session, final Throwable e) throws Exception {
        if (log.isDebugEnabled())
            log.debug("WebSocket Client Error.\n", e);
        if (handler != null &&
                handler instanceof IWebSocketSessionAwareMessageHandler)
            ((IWebSocketSessionAwareMessageHandler) handler).handleError(session, e);
    }


    public IMessageHandler getHandler() {
        return handler;
    }
    public void setHandler(IMessageHandler handler) {
        this.handler = handler;
    }
    public WebSocketClientHandler withHandler(IMessageHandler handler) {
        this.handler = handler;
        return this;
    }

}
