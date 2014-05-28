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
package co.niagarasystems.west.test.server.mock;

import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

/**
 * WEST Server Mock.
 */
public class WestServerMock {

    private Server jettyServer;

    public WestServerMock start() throws Exception {
        return start(8080);
    }

    public WestServerMock start(int port) throws Exception {
        jettyServer = new Server();
        ServerConnector connector = new ServerConnector(jettyServer);
        connector.setPort(port);
        jettyServer.addConnector(connector);

        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        ServletContextHandler context =
            new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        jettyServer.setHandler(context);

        try {
            // Initialize javax.websocket layer
            ServerContainer wscontainer =
                WebSocketServerContainerInitializer.configureContext(context);

            // Add WebSocket endpoint to javax.websocket layer
            wscontainer.addEndpoint(WestServerEndpointMock.class);

            jettyServer.start();
            //jettyServer.dump(System.err);
            //jettyServer.join();
        }
        catch (Throwable t) {
            t.printStackTrace(System.err);
        }
        return this;
    }

    public WestServerMock stop() throws Exception {
        jettyServer.stop();
        return this;
    }

    public WestServerMock join() throws Exception {
        jettyServer.join();
        return this;
    }

    public WestServerMock dump() throws Exception {
        jettyServer.dump(System.err);
        return this;
    }


    public Server getJettyServer() {
        return jettyServer;
    }
    public void setJettyServer(Server jettyServer) {
        this.jettyServer = jettyServer;
    }

}
