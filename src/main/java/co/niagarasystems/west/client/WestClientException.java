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
 * WestClientException wraps exceptions that occurs
 * inside of IWestClient.
 */
public class WestClientException extends Exception {

    /**
     * Auto-generated ID
     */
    private static final long serialVersionUID = 8139116373541157929L;

    /**
     * Constructs a new WestClientException with the specified message.
     *
     * @param message
     *            An error message describing what went wrong.
     */
    public WestClientException(String message) {
        super(message);
    }

    /**
     * Constructs a new WestClientException with the specified message and
     * exception indicating the root cause.
     *
     * @param message
     *            An error message describing what went wrong.
     * @param cause
     *            The root exception that caused this exception to be thrown.
     */
    public WestClientException(String message, Throwable cause) {
        super(message, cause);
    }

}
