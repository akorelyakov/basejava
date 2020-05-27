package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.Config;
import com.github.akorelyakov.webapp.ResumeTestData;
import com.github.akorelyakov.webapp.exception.ExistStorageException;
import com.github.akorelyakov.webapp.exception.NotExistStorageException;
import com.github.akorelyakov.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();
    protected Storage storage;

    private static final String UUID_1 = "uuid1                               ";
    private static Resume RESUME1;
    private static final String UUID_2 = "uuid2                               ";
    private static Resume RESUME2;
    private static final String UUID_3 = "uuid3                               ";
    private static Resume RESUME3;
    private static final String UUID_4 = "uuid4                               ";
    private static Resume RESUME4;
    private static final String dummyUuid = "dummyUuid";

    static {
        RESUME1 = ResumeTestData.getTestResume1(UUID_1);
        RESUME2 = ResumeTestData.getTestResume2(UUID_2);
        RESUME3 = ResumeTestData.getTestResume3(UUID_3);
        RESUME4 = ResumeTestData.getTestResume4(UUID_4);
    }

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
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
        storage.save(RESUME4);
        assertEquals(RESUME4, storage.get(UUID_4));
        assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        Resume resume = new Resume(UUID_1, "fullName1");
        storage.save(resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        storage.get(UUID_1);
        assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(dummyUuid);
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1, "New Name");
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume resume = new Resume(dummyUuid, "fullName1");
        storage.update(resume);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME1);
        assertGet(RESUME2);
        assertGet(RESUME3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(dummyUuid);
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(RESUME2, RESUME3, RESUME1));
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}