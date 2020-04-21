package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.exception.ExistStorageException;
import com.github.akorelyakov.webapp.exception.NotExistStorageException;
import com.github.akorelyakov.webapp.exception.StorageException;
import com.github.akorelyakov.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isFull(size())) {
            throw new StorageException("Storage is full!", resume.getUuid());
        } else if (isExist(index)) {
            throw new ExistStorageException(resume.getUuid());
        }
        getSave(resume, index);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (isExist(index)) {
            getDelete(uuid, index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExist(index)) {
            getUpdate(resume, index);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (isExist(index)) {
            return getResume(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract Resume getResume(int index);

    protected abstract int getIndex(String uuid);

    protected abstract boolean isFull(int size);

    protected abstract void getSave(Resume resume, int index);

    protected abstract boolean isExist(int index);

    protected abstract void getUpdate(Resume resume, int index);

    protected abstract void getDelete(String uuid, int index);
}