package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void doSave(Resume resume, Object r) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object resume) {
        storage.remove(((Resume) resume).getUuid());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected List<Resume> convertedStorageToList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }
}