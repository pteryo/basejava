package com.learnjava.storage;

import com.learnjava.exception.NotExistStorageException;
import com.learnjava.exception.StorageException;
import com.learnjava.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AbstractArrayStorageTest {
    private Storage storage;

    private static final Resume TEST_RESUME1 = new Resume("uuid1");
    private static final Resume TEST_RESUME2 = new Resume("uuid2");
    private static final Resume TEST_RESUME3 = new Resume("extra_uuid");

    protected void initArrayStorage() {
        this.storage = new ArrayStorage();
    }
    protected void initSortedStorage() {
        this.storage = new SortedArrayStorage();
    }

    @BeforeEach
    public void beforeEach() {
        if (storage != null){
            storage.clear();
            storage.save(TEST_RESUME1);
            storage.save(TEST_RESUME2);
        }
    }

    @Test
    void size() {
        Assertions.assertEquals(2, storage.size());
    }

    @Test
    void clear() {
        storage.clear();
        Assertions.assertEquals(0, storage.size());
    }

    @Test
    void update() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.get("not existing uuid");
        });
    }

    @Test
    void getAll() {
        Resume[] wholeStorage = storage.getAll();
        Assertions.assertEquals(2, wholeStorage.length);
    }

    @Test
    void save() {
        storage.save(TEST_RESUME3);
        Assertions.assertEquals(3, storage.size());
    }

    @Test
    public void overflow() {
        Assertions.assertThrows(StorageException.class, () -> {

            for (int i = storage.size() + 1; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
            storage.save(new Resume());
        });
    }

    @Test
    void delete() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.delete("uuid1");
            Assertions.assertEquals(1, storage.size());
            storage.get("uuid1");
        });
    }

    @Test
    void get() {
        Assertions.assertEquals(TEST_RESUME1, storage.get(TEST_RESUME1.getUuid()));
        Assertions.assertEquals(TEST_RESUME2, storage.get(TEST_RESUME2.getUuid()));
    }

  /*  @Test
    public void getNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.get("NON_EXISTING_UUID");
        });
    }

   */
}