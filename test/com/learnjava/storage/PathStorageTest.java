package com.learnjava.storage;

import com.learnjava.storage.serializer.DataStreamSerializer;

public class PathStorageTest extends AbstractStorageTest {
    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()), (new PathStorage(STORAGE_DIR_EMPTY.getAbsolutePath(), new DataStreamSerializer())));
    }
}
