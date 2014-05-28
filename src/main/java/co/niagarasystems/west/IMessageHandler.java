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
package co.niagarasystems.west;

/**
 * Defines a message handler.
 */
public interface IMessageHandler {

    /**
     * Handles a message.
     * This method will be called when a message arrives and should contain
     * the custom logic to execute when the message is received.
     *
     * @param message
     *          The message to handle.
     * @throws Exception
     *          If any error occurs.
     */
    void handle(IMessage<?> message) throws Exception;

}
