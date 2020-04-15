package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected void insertElement(Resume resume, int index) {
        storage[size] = resume;
    }

    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}