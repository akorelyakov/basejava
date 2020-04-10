package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        if (size != 0) {
            Arrays.fill(storage, 0, size, null);
        }
        size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("The storage is full!");
        } else if (index > -1) {
            System.out.println("Resume already exists in the storage!");
        } else {
            checkedSave(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            checkedDelete(index);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("No resume in the storage with such Uuid!");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index <= -1) {
            System.out.println("No resume in the storage with such Uuid!");
        } else {
            storage[index] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("No resume in the storage with such Uuid!");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void checkedDelete(int index);

    protected abstract void checkedSave(Resume resume, int index);
}