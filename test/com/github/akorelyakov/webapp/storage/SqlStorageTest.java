package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.Config;

public class SqlStorageTest extends AbstractStorageTest{

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}
