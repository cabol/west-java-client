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
package co.niagarasystems.west.client;

/**
 * Defines a WEST Client.
 */
public interface IWestClient {

    /**
     * Ping to the server.
     *
     * @param id
     *          Message identifier.
     * @throws WestClientException
     *          When an error occurs making ping to the server.
     */
    void ping(String id) throws WestClientException;

    /**
     * Register to a channel.
     *
     * @param id
     *          Message identifier.
     * @param channel
     *          Channel name to establish the registration.
     * @throws WestClientException
     *          When an error occurs at registering to a channel.
     */
    void register(String id, String channel) throws WestClientException;

    /**
     * Unregister from a channel.
     *
     * @param id
     *          Message identifier.
     * @param channel
     *          Channel name to remove the registration.
     * @throws WestClientException
     *          When an error occurs at unregistering from a channel.
     */
    void unregister(String id, String channel) throws WestClientException;

    /**
     * Send message to a channel.
     *
     * @param id
     *          Message identifier.
     * @param channel
     *          Channel name which message will be sent.
     * @param data
     *          Payload of the message that will be sent.
     * @throws WestClientException
     *          When an error occurs at send message to a channel.
     */
    void send(String id, String channel, byte[] data) throws WestClientException;

    /**
     * Subscribe to a channel.
     *
     * @param id
     *          Message identifier.
     * @param channel
     *          Channel name to establish the subscription.
     * @throws WestClientException
     *          When an error occurs at subscribing to a channel.
     */
    void subscribe(String id, String channel)throws WestClientException;

    /**
     * Unsubscribe from a channel.
     *
     * @param id
     *          Message identifier.
     * @param channel
     *          Channel name to remove the subscription.
     * @throws WestClientException
     *          When an error occurs at unsubscribing to a channel.
     */
    void unsubscribe(String id, String channel) throws WestClientException;

    /**
     * Publish message to a channel.
     *
     * @param id
     *          Message identifier.
     * @param channel
     *          Channel name which message will be published.
     * @param data
     *          Payload of the message that will be published.
     * @throws WestClientException
     *          When an error occurs at publish message to a channel.
     */
    void publish(String id, String channel, byte[] data) throws WestClientException;

}
