package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage implements Storage {

    protected ArrayList<Resume> storage = new ArrayList<Resume>();

    public void clear() {
        storage.clear();
    }

    @Override
    protected boolean isExist(int index) {
        return storage.contains(getResume(index));
    }

    @Override
    protected void getUpdate(Resume resume, int index) {
        storage.set(index, resume);
    }

    @Override
    protected boolean isFull(int size) {
        return false;
    }

    @Override
    protected void getSave(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(int index) {
        if (index >= 0) {
            return storage.get(index);
        }
        return null;
    }

    @Override
    protected void getDelete(String uuid, int index) {
        storage.remove(index);
    }

    public Resume[] getAll() {
        return storage.toArray(Resume[]::new);
    }

    public int size() {
        return storage.size();
    }

    protected int getIndex(String uuid) {
        for (Resume r : storage) {
            if (uuid.equals(r.getUuid())) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }
}