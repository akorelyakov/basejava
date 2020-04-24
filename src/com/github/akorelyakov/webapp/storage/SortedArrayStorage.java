package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    protected void insertElement(Resume resume, int index) {
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = resume;
    }

    protected void fillDeletedElement(int index) {
        if (size - 1 - index >= 0)
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "name");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}