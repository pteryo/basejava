package com.learnjava.storage;
import com.learnjava.storage.serializer.JsonStreamSerializer;
public class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()),new PathStorage(STORAGE_DIR_EMPTY.getAbsolutePath(), new JsonStreamSerializer()));
    }
}