package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    private int getIndex(Resume r) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == r.getUuid()) {
                index = i;
            }
        }
        return index;
    }

    private int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                index = i;
            }
        }
        return index;
    }

    public void clear() {
        if (size != 0) {
            Arrays.fill(storage, 0, size, null);
        }
        size = 0;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Storage is full!");
        } else {
            if (getIndex(r) == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Resume already exists in storage!");
            }
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("No resume in storage with such Uuid!");
            return null;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("No resume in storage with such Uuid!");
        }
    }

    public void update(Resume r) {
        int index = getIndex(r);
        if (index != -1) {
            storage[index] = r;
        } else {
            System.out.println("No resume in storage with such Uuid!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}