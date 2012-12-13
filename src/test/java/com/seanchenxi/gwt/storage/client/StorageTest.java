/*
 * Copyright 2012 Xi CHEN
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.seanchenxi.gwt.storage.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.SerializationException;

/**
 * Created by: Xi
 */
public class StorageTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.seanchenxi.gwt.storage.StorageTest";
  }

  public void testStoragePUT() throws StorageQuotaExceededException, SerializationException {
    System.out.print("begin");
    StorageExt localStorage = StorageExt.getLocalStorage();
    assertNotNull(localStorage);
    StorageExt sessionStorage = StorageExt.getSessionStorage();
    assertNotNull(sessionStorage);

    int localStorageLength = localStorage.size();
    int sessionStorageLength = sessionStorage.size();

    putStringValue(localStorage, ++localStorageLength);
    putStringValue(sessionStorage, ++sessionStorageLength);

    putBooleanValue(localStorage, ++localStorageLength);
    putBooleanValue(sessionStorage, ++sessionStorageLength);

    putIntegerValue(localStorage, ++localStorageLength);
    putIntegerValue(sessionStorage, ++sessionStorageLength);
  }

  private static void putStringValue(StorageExt storage, int expectedSize) throws SerializationException, StorageQuotaExceededException {
    StorageKey<String> key = new StorageKey<String>("testString", String.class);
    final String value = "StringValue";
    storage.put(key, value);
    assertEquals(expectedSize, storage.size());
    assertTrue(storage.containsKey(key));
    assertEquals(value, storage.get(key));
  }

  private static void putBooleanValue(StorageExt storage, int expectedSize) throws SerializationException, StorageQuotaExceededException {
    StorageKey<Boolean> key = new StorageKey<Boolean>("testBoolean", Boolean.class);
    final Boolean value = Boolean.FALSE;
    storage.put(key, value);
    assertEquals(expectedSize, storage.size());
    assertTrue(storage.containsKey(key));
    assertEquals(value, storage.get(key));
  }

  private static void putIntegerValue(StorageExt storage, int expectedSize) throws SerializationException, StorageQuotaExceededException {
    StorageKey<Integer> key = new StorageKey<Integer>("testInteger", Integer.class);
    final Integer value = Integer.MAX_VALUE;
    storage.put(key, value);
    assertEquals(expectedSize, storage.size());
    assertTrue(storage.containsKey(key));
    assertEquals(value, storage.get(key));
  }

}
