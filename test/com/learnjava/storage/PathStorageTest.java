package com.learnjava.storage;

import com.learnjava.serializer.ObjectStreamSerializer;

public class PathStorageTest  extends AbstractStorageTest {
    public  PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()), (new PathStorage(STORAGE_DIR_EMPTY.getAbsolutePath(), new ObjectStreamSerializer())));
    }
}
