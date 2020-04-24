package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    public void clear() {
        storage.clear();
    }

    @Override
    protected List<Resume> convertedStorageToList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected Resume doGet(Object uuid) {
        return storage.get(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume resume, Object uuid) {
        storage.put((String) uuid, resume);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, Object uuid) {
        storage.replace((String) uuid, resume);
    }

    @Override
    protected void doDelete(Object uuid) {
        storage.remove(uuid);
    }

    public int size() {
        return storage.size();
    }
}