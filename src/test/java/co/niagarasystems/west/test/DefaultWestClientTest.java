package co.niagarasystems.west.test;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.niagarasystems.west.IWest;
import co.niagarasystems.west.client.IWestClient;
import co.niagarasystems.west.client.support.DefaultWestClient;
import co.niagarasystems.west.io.CodecUtils;
import co.niagarasystems.west.test.server.mock.WestServerMock;

public class DefaultWestClientTest {

    // Logger
    private static final Logger log =
        Logger.getLogger(DefaultWestClientTest.class);

    // Spring Application Context
    private static ApplicationContext applicationContext;

    // WEST server mock
    private static WestServerMock westServer;

    // Resources
    private IWestClient client;
    private Map<?, ?> events;


    ///////////////////////////////////////////////////////////////////////////
    // SETUP AND CLEANUP
    ///////////////////////////////////////////////////////////////////////////


    @BeforeClass
    public static void setup() {
        log.info(" --- setup() --- ");

        // get application context
        try {
            // Initialize javax.websocket layer
            westServer = new WestServerMock();
            westServer.start().dump();

            applicationContext =
                new ClassPathXmlApplicationContext(
                    new String[] {
                        "classpath:META-INF/spring/test/appContext.xml"
                    });
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Before
    public void init() {
        client = applicationContext.getBean("westClient", IWestClient.class);
        events = applicationContext.getBean("events", Map.class);
    }

    @AfterClass
    public static void cleanup() {
        log.info(" --- cleanup() --- ");

        try {
            IWestClient client = applicationContext.getBean("westClient", IWestClient.class);

            // Close session
            ((DefaultWestClient) client).getSession().close();

            // Stop server
            westServer.stop();

            Thread.sleep(1000);
        }
        catch (Exception e) {
            log.error("Unexpected Error.", e);
            Assert.fail();
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // TESTS
    ///////////////////////////////////////////////////////////////////////////


    @Test
    public void testResourceInjection() {
        log.info(" --- testResourceInjection() --- ");

        Assert.assertNotNull(client);
        Assert.assertNotNull(events);
    }

    @Test
    public void testSpringWestClient() {
        log.info(" --- testSpringWestClient() --- ");

        try {
            // Ping
            client.ping("123");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.PONG, events.get("123"));

            /////////////////////////////////////////////////////////
            // STRINGS

            // Register
            client.register("1", "strings");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.REGISTRATION_SUCCEEDED, events.get("1"));
            // Send message
            client.send("2", "strings", CodecUtils.encode("Hi!"));
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.SENDING_SUCCEEDED, events.get("2"));
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.NEW_MESSAGE, events.get("client-2"));
            // Unregister
            client.unregister("3", "strings");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.UNREGISTRATION_SUCCEEDED, events.get("3"));
            // Send message again
            client.send("4", "strings", CodecUtils.encode("Hi!"));
            Thread.sleep(1000);
            Assert.assertFalse(IWest.IEvent.SENDING_SUCCEEDED.equals(events.get("4")));

            // Subscribe
            client.subscribe("5", "strings");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.SUBSCRIPTION_SUCCEEDED, events.get("5"));
            // Publish
            client.publish("6", "strings", "Hi PubSub!".getBytes());
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.PUBLICATION_SUCCEEDED, events.get("6"));
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.NEW_MESSAGE, events.get("client-6"));
            // Unsubscribe
            client.unsubscribe("7", "strings");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.UNSUBSCRIPTION_SUCCEEDED, events.get("7"));
            // Publish again
            client.publish("8", "strings", "Hi PubSub!".getBytes());
            Thread.sleep(1000);
            Assert.assertFalse(IWest.IEvent.PUBLICATION_SUCCEEDED.equals(events.get("8")));

            /////////////////////////////////////////////////////////
            // ACCOUNTS

            // Create account
            Account account =
                new Account()
                    .withUser("cabolanos")
                    .withPassword("password")
                    .withPerson(
                        new Person()
                            .withName("Andres")
                            .withId("1234")
                            .withEmail("me@mydomain.com"));
            byte[] bytes = CodecUtils.encode(account);

            // Register
            client.register("11", "accounts");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.REGISTRATION_SUCCEEDED, events.get("11"));
            // Send message
            client.send("22", "accounts", bytes);
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.SENDING_SUCCEEDED, events.get("22"));
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.NEW_MESSAGE, events.get("client-22"));
            // Unregister
            client.unregister("33", "accounts");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.UNREGISTRATION_SUCCEEDED, events.get("33"));
            // Send message again
            client.send("44", "accounts", bytes);
            Thread.sleep(1000);
            Assert.assertFalse(IWest.IEvent.SENDING_SUCCEEDED.equals(events.get("44")));

            // Subscribe
            client.subscribe("55", "accounts");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.SUBSCRIPTION_SUCCEEDED, events.get("55"));
            // Publish
            client.publish("66", "accounts", bytes);
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.PUBLICATION_SUCCEEDED, events.get("66"));
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.NEW_MESSAGE, events.get("client-66"));
            // Unsubscribe
            client.unsubscribe("77", "accounts");
            Thread.sleep(1000);
            Assert.assertEquals(IWest.IEvent.UNSUBSCRIPTION_SUCCEEDED, events.get("77"));
            // Publish again
            client.publish("88", "accounts", bytes);
            Thread.sleep(1000);
            Assert.assertFalse(IWest.IEvent.PUBLICATION_SUCCEEDED.equals(events.get("88")));
        }
        catch (Exception e) {
            log.error("Unexpected Error.", e);
            Assert.fail();
        }
    }

}
