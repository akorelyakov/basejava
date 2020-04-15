package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.exception.ExistStorageException;
import com.github.akorelyakov.webapp.exception.NotExistStorageException;
import com.github.akorelyakov.webapp.exception.StorageException;
import com.github.akorelyakov.webapp.model.Resume;
import org.junit.*;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    Resume resume1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    Resume resume2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    Resume resume3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    Resume resume4 = new Resume(UUID_4);

    @Before
    public void setUp() throws Exception {
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @After
    public void tearDown() {
        storage.clear();
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        storage.save(resume4);
        assertEquals(resume4, storage.get(UUID_4));
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i < AbstractArrayStorage.STORAGE_LIMIT + 1; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail();
        }
        storage.save(new Resume());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        Resume resume = new Resume("uuid1");
        storage.save(resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummyUuid");
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1);
        storage.update(resume);
        assertTrue(resume.equals(storage.get(UUID_1)));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume resume = new Resume("dummyUuid");
        storage.update(resume);
    }

    @Test
    public void get() {
        Resume resume = new Resume(UUID_1);
        assertTrue(resume.equals(storage.get(UUID_1)));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        Resume[] actual = storage.getAll();
        Resume[] expected = {resume1, resume2, resume3};
        assertEquals(expected, actual);
    }
}