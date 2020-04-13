package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected void checkedSave(Resume resume, int index) {
        int searchIndex = -index - 1;
        for (int i = 0; i > size - searchIndex; i++) {
            storage[size - i - 1] = storage[size - i - 2];
        }
        storage[searchIndex] = resume;
    }

    protected void checkedDelete(int index) {
        if (size - 1 - index >= 0)
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}