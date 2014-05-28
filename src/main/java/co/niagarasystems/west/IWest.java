/*
 * Copyright 2014 Niagara Systems Inc
 *
 * Licensed under the Apache License; Version 2.0  = the "License";
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing; software
 * distributed under the License is distributed on an "AS IS" BASIS;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND; either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.niagarasystems.west;

/**
 * Commons.
 */
public interface IWest {

    /**
     * WEST message headers.
     */
    interface IHeader {

        public static final String EVENT = "west-event";
        public static final String CHANNEL = "west-channel";
        public static final String FROM = "west-from";
        public static final String ID = "west-id";

    }

    /**
     * WEST commands.
     */
    interface ICommand {

        public static final String PING = "ping";
        public static final String REGISTER = "register";
        public static final String UNREGISTER = "unregister";
        public static final String SEND = "send";
        public static final String SUBSCRIBE = "subscribe";
        public static final String UNSUBSCRIBE = "unsubscribe";
        public static final String PUBLISH = "publish";

    }

    /**
     * WEST events.
     */
    interface IEvent {

        public static final String CONNECTION_ESTABLISHED = "connection_established";
        public static final String CONNECTION_CLOSED = "connection_closed";
        public static final String CONNECTION_ERROR = "connection_error";
        public static final String INTERNAL_ERROR = "internal_error";
        public static final String BAD_REQUEST = "bad_request";
        public static final String TIMEOUT = "timeout";
        public static final String ACTION_NOT_ALLOWED = "action_not_allowed";
        public static final String NEW_MESSAGE = "new_message";
        public static final String CHANNEL_NOT_FOUND = "channel_not_found";
        public static final String CHANNEL_CREATION_SUCCEEDED = "channel_creation_succeeded";
        public static final String CHANNEL_ALREADY_EXIST = "channel_already_exist";
        public static final String CHANNEL_CREATION_FAILED = "channel_creation_failed";
        public static final String CHANNEL_DELETE_SUCCEEDED = "channel_delete_succeeded";
        public static final String CHANNEL_DELETE_FAILED = "channel_delete_failed";
        public static final String PONG = "pong";
        public static final String REGISTRATION_SUCCEEDED = "registration_succeeded";
        public static final String REGISTRATION_FAILED = "registration_failed";
        public static final String REGISTRATION_ALREADY_EXIST = "registration_already_exist";
        public static final String REGISTRATION_NOT_FOUND = "registration_not_found";
        public static final String REGISTRATION_DENIED = "registration_denied";
        public static final String UNREGISTRATION_SUCCEEDED = "unregistration_succeeded";
        public static final String UNREGISTRATION_FAILED = "unregistration_failed";
        public static final String SENDING_SUCCEEDED = "sending_succeeded";
        public static final String SENDING_FAILED = "sending_failed";
        public static final String SUBSCRIPTION_SUCCEEDED = "subscription_succeeded";
        public static final String SUBSCRIPTION_ALREADY_EXIST = "subscription_already_exist";
        public static final String SUBSCRIPTION_NOT_FOUND = "subscription_not_found";
        public static final String SUBSCRIPTION_FAILED = "subscription_failed";
        public static final String UNSUBSCRIPTION_SUCCEEDED = "unsubscription_succeeded";
        public static final String UNSUBSCRIPTION_FAILED = "unsubscription_failed";
        public static final String PUBLICATION_SUCCEEDED = "publication_succeeded";
        public static final String PUBLICATION_FAILED = "publication_failed";

    }

}
