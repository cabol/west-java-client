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

import java.net.URI;
import java.util.Properties;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import co.niagarasystems.west.client.WestClientException;

/**
 * Defines a WebSocket Session Factory.
 */
public class WebSocketSessionFactory {

    // URI
    private URI uri;

    // WebSocket Container
    private WebSocketContainer container = null;

    // WebSocket Client Handler
    private WebSocketClientHandler wsClientHandler = null;

    // WebSocket Properties
    private Properties properties = new Properties();


    /** Constructor */
    public WebSocketSessionFactory(String uri) {
        this.uri = URI.create(uri);
        container = ContainerProvider.getWebSocketContainer();
    }

    /** Constructor */
    public WebSocketSessionFactory(
            String uri, WebSocketClientHandler wsClientHandler) {
        this.uri = URI.create(uri);
        this.wsClientHandler = wsClientHandler;
        container = ContainerProvider.getWebSocketContainer();
    }


    /**
     * Create an instance of WebSocket Session.
     *
     * @return
     *          WebSocket Session.
     * @throws WestClientException
     *          When some error occurs connecting to the server.
     */
    public Session createSession() throws WestClientException {
        try {
            return container.connectToServer(wsClientHandler, uri);
        }
        catch (Exception e) {
            throw new WestClientException(
                "Error initializing WebSocket connection.", e);
        }
    }

    /**
     * Create an instance of WebSocket Session with the given
     * WebSocketClientHandler.
     *
     * @param wsClientHandler
     *          WebSocket Client Endpoint.
     * @return
     *          WebSocket Session.
     * @throws WestClientException
     *          When some error occurs connecting to the server.
     */
    public Session createSession(WebSocketClientHandler wsClientHandler)
            throws WestClientException {
        try {
            return container.connectToServer(wsClientHandler, uri);
        }
        catch (Exception e) {
            throw new WestClientException(
                "Error initializing WebSocket connection.", e);
        }
    }


    public URI getUri() {
        return uri;
    }

    public Properties getProperties() {
        return properties;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
