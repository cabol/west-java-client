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

import javax.websocket.CloseReason;
import javax.websocket.Session;

import co.niagarasystems.west.IMessageHandler;

/**
 * Defines a handler to control WebSocket Session events.
 */
public interface IWebSocketSessionAwareMessageHandler extends IMessageHandler {

    /**
     * Called event when a new web socket session is open.
     *
     * @param session
     *          WebSocket session.
     * @throws Exception
     *          If any error occurs.
     */
    void handleOpen(Session session) throws Exception;

    /**
     * Called when a web socket session is closing.
     *
     * @param session
     *          WebSocket session.
     * @param closeReason
     *          Close reason.
     * @throws Exception
     *          If any error occurs.
     */
    void handleClose(Session session, CloseReason closeReason) throws Exception;

    /**
     * Handle errors.
     *
     * @param session
     *          WebSocket session.
     * @param e
     *          Exception.
     * @throws Exception
     *          If any error occurs.
     */
    void handleError(Session session, Throwable e) throws Exception;

}
