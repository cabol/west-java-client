
WEST Java Client
================

__Authors:__ Carlos Andres Bolaños R.A. ([`cabolanos.dev@gmail.com`](mailto:cabolanos.dev@gmail.com)).

This document describes how to use the Java client to interact with WEST.



Overview
--------

[WEST](https://github.com/cabolanos/west) is a tool that enables the development of real-time, mission-critical and messaging-based systems, [EDA](http://en.wikipedia.org/wiki/Event-driven_architecture) based systems. It exposes different APIs via WebSockets: Protocol Puffers, JSON and Text. This is a Java client for talking to WEST via a single interface, regardless of underlying transport.



Prerequisites
-------------

* Java 7 (or later)
* Maven (2.x.x or later)



Building west-java-client
-------------------------

Assuming you have a working Java (7 or later) installation, building **WEST** Java client should be as simple as:

    $ git clone https://github.com/cabolanos/west-java-client.git
    $ cd west-java-client
    $ mvn install

Test execution is enabled by default, if you want to skip tests:

    $ mvn install -DskipTests=true

After do this, you will find in the target dir the compiled `JAR` file, and by other hand a `ZIP` file with the same `JAR` inside and also a lib dir with all dependency `JARs` (in case to be necessary). Now you can include the generated `JAR` in your `CLASSPATH`.



Using riak-java-client
----------------------

Two implementations of `IWestClient` are provided here: `DefaultWestClient` and `SpringWestClient`.


### Example using `DefaultWestClient` ###

Let's start defining a handler:

```java
import co.niagarasystems.west.IMessage;
import co.niagarasystems.west.IMessageHandler;

public class MyHandler implements IMessageHandler {

    @Override
    public void handle(IMessage<?> message) throws Exception {
        System.out.println(">> NEW MESSAGE: " + message.toString());
    }

}
```

This handler will be called for incoming messages. If you want to control the WebSocket session too, your handler should implement `IWebSocketSessionAwareMessageHandler`, this interface extends from `IMessageHandler` and provides additional methods that enables you control the session.

Assuming you’re running **WEST** on localhost on the default ports getting started is as simple as:

```java
// Create the client
IWestClient client =
    new DefaultWestClient(
        new WebSocketClientHandler(new MyHandler()), // Handler
        "ws://localhost:8080/west/client123");       // URI
```

Now client is ready to send commands and receive events:

```java
// Ping message
client.ping("123");

// Register
client.register("1", "test_channel");
Thread.sleep(1000);

// Send message
client.send("2", "test_channel", CodecUtils.encode("Hi!"));
Thread.sleep(1000);

// Unregister
client.unregister("3", "test_channel");
Thread.sleep(1000);

// Subscribe
client.subscribe("4", "pubsub_channel");
Thread.sleep(1000);

// Publish
client.publish("5", "pubsub_channel", "Hi PubSub!".getBytes());
Thread.sleep(1000);

// Unsubscribe
client.unsubscribe(6", "pubsub_channel");
Thread.sleep(1000);
```


### Example using `SpringWestClient` ###

The Spring Framework provides a WebSocket API designed to adapt to various WebSocket engines. For example, it runs on JSR-356 runtimes such as Tomcat (7.0.47+), GlassFish (4.0+) and WildFly (8.0+) but can also adapt to other WebSocket runtimes such as the Jetty (9.1+) native WebSocket support. For more information consult [here](http://docs.spring.io/spring/docs/4.0.5.RELEASE/spring-framework-reference/htmlsingle/#websocket).

**WEST Java Client** provides `WestProtobuffsWebSocketHandler`, a simple handler that extends from `BinaryWebSocketHandler` ( a handler provided by Spring WebSocket), receives all incoming binary messages, these are decoded from binary to `org.springframework.messaging.Message`, and then the additional method defined in this handler `handleProtobuffsMessage(..)` is invoked.

As in the previous example, let's start defining a handler:

```java
import org.springframework.messaging.Message;
import org.springframework.web.socket.WebSocketSession;

import co.niagarasystems.west.client.spring.WestProtobuffsWebSocketHandler;

public class MyHandler extends WestProtobuffsWebSocketHandler {

    @Override
    public void handleProtobuffsMessage(WebSocketSession session, Message<?> message) throws Exception {
        System.out.println(MyHandler.class.getName() + ": " + message);
    }

}
```

For this example let's use XML configuration style. This is the XML namespace:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Standard WebSocket Container -->
    <bean id="wsContainer"
          class="javax.websocket.ContainerProvider"
          factory-method="getWebSocketContainer"/>

    <!-- Standard WebSocket Client -->
    <bean id="wsClient" class="org.springframework.web.socket.client.standard.StandardWebSocketClient">
        <constructor-arg ref="wsContainer"/>
    </bean>

    <!-- Handler -->
    <bean id="myHandler" class="co.niagarasystems...MyHandler">
        <property name="events" ref="events"/>
    </bean>
    
    <!-- WEST Client -->
    <bean id="headers" class="org.springframework.web.socket.WebSocketHttpHeaders"/>
    <bean id="springWestClient" class="co.niagarasystems.west.client.spring.SpringWestClient">
        <property name="session">
            <value>
                #{ wsClient.doHandshake(myHandler, headers, T(java.net.URI).create('ws://localhost:8080/west/client123')).get() }
            </value>
        </property>
    </bean>

</beans>
```

Now we need to load the Spring `ApplicationContext` and get an instance of `SpringWestClient`:

```java
// Load the Spring ApplicationContext
ApplicationContext context =
    new ClassPathXmlApplicationContext(
        "classpath:META-INF/.../appContext.xml");

// Get instance of IWestClient
IWestClient client = context.getBean("springWestClient", IWestClient.class);
```

Now we are able to send commands and receive events (such as in the previous example):

```java
// Ping message
client.ping("123");

// Register
client.register("1", "test_channel");
Thread.sleep(1000);

// Send message
client.send("2", "test_channel", CodecUtils.encode("Hi!"));
Thread.sleep(1000);

// Unregister
client.unregister("3", "test_channel");
Thread.sleep(1000);

// Subscribe
client.subscribe("4", "pubsub_channel");
Thread.sleep(1000);

// Publish
client.publish("5", "pubsub_channel", "Hi PubSub!".getBytes());
Thread.sleep(1000);

// Unsubscribe
client.unsubscribe(6", "pubsub_channel");
Thread.sleep(1000);
```

### Note ###

> You can also review the tests into the code, there you will find clear examples of both `DefaultWestClient` and `SpringWestClient`.


License
=======

**WEST Java Client** is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).
