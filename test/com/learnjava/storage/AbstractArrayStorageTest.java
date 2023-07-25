package com.learnjava.storage;

import com.learnjava.exception.StorageException;
import com.learnjava.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage, Storage emptyStorage) {
        super(storage, emptyStorage);
    }
    @Test
    void overflow() {
            storage.clear();
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("dummy" + i ));
            }
            Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume("full dummy")));

    }
}

