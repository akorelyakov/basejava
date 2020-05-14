package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.storage.serializer.JsonStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()));
    }
}