package com.github.akorelyakov.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " is not exists in the storage!", uuid);
    }
}
