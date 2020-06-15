package com.github.akorelyakov.webapp.storage;

import com.github.akorelyakov.webapp.Config;
import com.github.akorelyakov.webapp.ResumeTestData;
import com.github.akorelyakov.webapp.exception.ExistStorageException;
import com.github.akorelyakov.webapp.exception.NotExistStorageException;
import com.github.akorelyakov.webapp.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.*;

import static com.github.akorelyakov.webapp.model.ContactType.*;
import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();
    protected Storage storage;

    private static final String UUID_1 = UUID.randomUUID().toString();
    private static Resume RESUME1;
    private static final String UUID_2 = UUID.randomUUID().toString();
    private static Resume RESUME2;
    private static final String UUID_3 = UUID.randomUUID().toString();
    private static Resume RESUME3;
    private static final String UUID_4 = UUID.randomUUID().toString();
    private static Resume RESUME4;
    private static final String dummyUuid = "dummyUuid";
    private static Resume RESUME5;
    private static final String UUID_5 = UUID.randomUUID().toString();

    static {
        RESUME1 = ResumeTestData.getTestResume1(UUID_1);
        RESUME2 = ResumeTestData.getTestResume2(UUID_2);
        RESUME3 = ResumeTestData.getTestResume3(UUID_3);
        RESUME4 = ResumeTestData.getTestResume4(UUID_4);
        RESUME5 = ResumeTestData.getTestResume4(UUID_5);
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
        resume.addContact(PHONE, "+1231231");
        resume.addContact(SKYPE, "new skype");
        resume.addContact(MAIL, "mailto:gkislin@yandex.ru");
        List<String> achievementList = new ArrayList<>();
        achievementList.add("Достижения - резюме 4, пункт 1");
        achievementList.add("Достижения - резюме 4, пункт 2");
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(achievementList));
        List<String> qualificationList = new ArrayList<>();
        qualificationList.add("Квалификация - резюме 4, пункт 1");
        qualificationList.add("Квалификация - резюме 4, пункт 2");
        qualificationList.add("Квалификация - резюме 4, пункт 3");
        resume.addSection(SectionType.QUALIFICATION, new ListSection(qualificationList));
//        List<Organization> experienceList = new ArrayList<>();
//        experienceList.add(
//                new Organization("Опыт работы - резюме 4, пункт 1", "http://javaops.ru/",
//                        new Organization.Position(LocalDate.of(2019, 6, 1),
//                                LocalDate.of(2020, 4
//                                        , 1),
//                                "Должность",
//                                "Описание")));
//        experienceList.add(new Organization("Опыт работы - резюме 4, пункт 2", "https://www.wrike" +
//                ".com/"
//                , new Organization.Position(LocalDate.of(2013, 10, 1)
//                , LocalDate.of(2016, 1, 1)
//                , "Должность"
//                , "Описание")));
//        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(experienceList));
//        List<Organization> educationList = new ArrayList<>();
//        educationList.add(new Organization("Образование - резюме 4, пункт 1", "https://www" +
//                ".coursera" +
//                ".org/course"
//                , new Organization.Position(LocalDate.of(2016, 3, 1)
//                , LocalDate.of(2018, 5, 1)
//                , "Заголовок", null)));
//        educationList.add(new Organization("Образование - резюме 4, пункт 1", "http://www.luxoft.ru/"
//                , new Organization.Position(LocalDate.of(2011, 3, 1)
//                , LocalDate.of(2011, 4, 1)
//                , "Заголовок", null)));
//        resume.addSection(SectionType.EDUCATION, new OrganizationSection(educationList));
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