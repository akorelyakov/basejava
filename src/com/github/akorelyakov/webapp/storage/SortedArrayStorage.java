package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("The storage is full!");
        } else if (index > -1) {
            System.out.println("Resume already exists in the storage!");
        } else {
            int searchIndex = -index - 1;
            for (int i = 0; i > size - searchIndex; i++) {
                storage[size - i - 1] = storage[size - i - 2];
            }
            storage[searchIndex] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("No resume in the storage with such Uuid!");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}