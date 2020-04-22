package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;

public class MapStorage extends AbstractStorage {
    private HashMap<String, Resume> storage = new HashMap<>();

    public void clear() {
        storage.clear();
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(searchKey);
    }

    //https://javarush.ru/groups/posts/1940-klass-hashmap-
    public Resume[] getAll() {
        ArrayList<Resume> resumes = new ArrayList<>(storage.values());
        return resumes.toArray(Resume[]::new);
    }

    public int size() {
        return storage.size();
    }
}