package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.exception.ExistStorageException;
import com.github.akorelyakov.webapp.exception.NotExistStorageException;
import com.github.akorelyakov.webapp.model.Resume;

import java.util.ArrayList;

public abstract class AbstractStorage implements Storage {
    protected ArrayList<Resume> storage;

    public AbstractStorage(ArrayList storage) {
        this.storage = storage;
    }

    public void clear() {
        storage.clear();
    }

    public void update(Resume resume) {
        if (!storage.contains(resume)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            int index = getIndex(resume.getUuid());
            storage.set(index, resume);
        }
    }

    public void save(Resume resume) {
        if (storage.contains(resume)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            storage.add(resume);
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage.get(index);
        }
        throw new NotExistStorageException(uuid);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage.remove(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Resume[] getAll() {
        return storage.toArray(Resume[]::new);
    }

    public int size() {
        return storage.size();
    }

    protected abstract int getIndex(String uuid);
}