package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.exception.StorageException;
import com.github.akorelyakov.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                super.storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("Storage premature overflow");
        }
        super.storage.save(new Resume());
    }
}
