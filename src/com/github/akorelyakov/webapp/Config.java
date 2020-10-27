package com.github.akorelyakov.webapp;

import com.github.akorelyakov.webapp.storage.SqlStorage;
import com.github.akorelyakov.webapp.storage.Storage;

import java.io.*;
import java.util.Properties;

public class Config {
    private static final String PROPS = "/resumes.properties";
    public static final Config INSTANCE = new Config();

    private File storageDir;
    private Storage storage;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream is = Config.class.getResourceAsStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            storageDir = new File(props.getProperty("storage.dir"));
            storage = new SqlStorage(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS);
        }
    }

    public File getStorageDir() {
        return storageDir;
    }

    public Storage getStorage() {
        return storage;
    }
}