package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.storage.serializer.ObjectStreamSerializer;


public class PathStorageTest extends AbstractStorageTest {

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }
}