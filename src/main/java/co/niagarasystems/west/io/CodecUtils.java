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
package co.niagarasystems.west.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Codec utility methods to facilitate serialization and deserialization
 * of objects.
 */
public class CodecUtils {

    /**
     * Serialize the given object into a byte array.
     *
     * @param object
     *          Object to be serialized.
     * @return
     *          A byte array representing the object.
     * @throws IOException
     *          When any error occurs serializing the object.
     */
    public static <T> byte[] encode(T object) throws IOException {
        if (object instanceof byte[])
            return (byte[]) object;
        else if (object instanceof String)
            return ((String) object).getBytes();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(object);
            return  bos.toByteArray();
        }
        finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (Exception ignore) { }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception ignore) { }
            }
        }
    }

    /**
     * Deserialize the given byte array into an instance of the
     * given type <T>.
     *
     * @param data
     *          Byte array to be deserialized.
     * @param clazz
     *          Type of the object that will be deserialize.
     * @return
     *          An instance of <T>.
     * @throws IOException
     *          When any error occurs serializing the object.
     * @throws ClassNotFoundException
     *          If the class of a serialized object cannot be found.
     */
    public static <T> T decode(byte[] data, Class<T> clazz)
            throws IOException, ClassNotFoundException {
        if (clazz.isInstance(data))
            return clazz.cast(data);
        else if (clazz.isInstance(String.valueOf(data)))
            return clazz.cast(new String(data));

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            T object = clazz.cast(in.readObject());
            return object;
        }
        finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (Exception ignore) { }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignore) { }
            }
        }
    }

}
