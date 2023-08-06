package com.learnjava.storage;

import com.learnjava.exception.NotExistStorageException;
import com.learnjava.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.learnjava.ResumeTestData.getFilledResume;

public abstract class AbstractStorageTest {
    protected Storage storage;
    protected Storage emptyStorage;
    protected static final File STORAGE_DIR = new File("D:\\YandexDisk\\_java_learn\\storage_files\\full");
    protected static final File STORAGE_DIR_EMPTY = new File("D:\\YandexDisk\\_java_learn\\storage_files\\empty");
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = getFilledResume(UUID_1, "Ivanov");

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = getFilledResume(UUID_2,"Petrov");

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = getFilledResume(UUID_3,"Sidorov");

    private static final String UUID_4 = "extra_uuid";
    private static final Resume RESUME_4 = getFilledResume(UUID_4,"Kuznetcov");

    private static final String UUID_NOT_EXIST = "NON_EXISTENT_UUID";
    private static final Resume RESUME_5 = getFilledResume(UUID_NOT_EXIST,"Gzhegosh");

    protected AbstractStorageTest(Storage storage,  Storage emptyStorage) {
        this.storage = storage;
        this.emptyStorage = emptyStorage;
    }

    @BeforeEach
    public void beforeEach() {
        if (storage != null) {
            storage.clear();
            storage.save(RESUME_1);
            storage.save(RESUME_2);
            storage.save(RESUME_3);
        }
    }

    private void assertGet(Resume r) {
        Assertions.assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        Assertions.assertEquals(size, storage.size());
    }


    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
        Assertions.assertArrayEquals(storage.getAllSorted().toArray(), emptyStorage.getAllSorted().toArray());
    }

    @Test
    void update() {
        Resume newResume = new Resume(UUID_1,"Ivanov");
        storage.update(newResume);
        Assertions.assertTrue(newResume.equals(storage.get(UUID_1)));
    }

    @Test
    void getAllSorted() {
        List<Resume> list = storage.getAllSorted();
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(list, Arrays.asList(RESUME_1, RESUME_2, RESUME_3));
    }

    @Test
    void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_1));
    }

    @Test
    void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    void getNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_NOT_EXIST));
    }

    @Test
    void deleteNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_NOT_EXIST));
    }

    @Test
    public void updateNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_5));
    }
}
