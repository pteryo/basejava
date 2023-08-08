package com.learnjava.storage;

import com.learnjava.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()), new PathStorage(STORAGE_DIR_EMPTY.getAbsolutePath(), new XmlStreamSerializer()));
    }
}
