package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage implements Storage {

    protected List<Resume> storage = new ArrayList<>();

    public void clear() {
        storage.clear();
    }

    @Override
    protected boolean isExist(Object index) {
        return index != null;
    }

    @Override
    protected void doUpdate(Resume resume, Object index) {
        storage.set((Integer) index, resume);
    }

    @Override
    protected void doSave(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected List<Resume> convertedStorageToList() {
        return new ArrayList<>(storage);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    @Override
    protected void doDelete(Object index) {
        storage.remove(((Integer) index).intValue());
    }

    public int size() {
        return storage.size();
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}