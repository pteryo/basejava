package com.learnjava.storage;

import com.learnjava.serializer.ObjectStreamSerializer;

public class FileStorageTest extends AbstractStorageTest {

    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()), (new FileStorage(STORAGE_DIR_EMPTY, new ObjectStreamSerializer())));
    }
}