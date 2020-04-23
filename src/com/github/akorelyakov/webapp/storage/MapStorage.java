package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    public void clear() {
        storage.clear();
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
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
    //https://javarush.ru/groups/posts/844-kak-praviljhno-delatjh-sortirovku-v-java
    public Resume[] getAll() {
        ArrayList<Resume> resumes = new ArrayList<>(storage.values());
        Resume[] sortedResumes = resumes.toArray(Resume[]::new);
        Arrays.sort(sortedResumes, new Comparator<Resume>() {
            public int compare(Resume o1, Resume o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        return sortedResumes;
    }

    public int size() {
        return storage.size();
    }
}