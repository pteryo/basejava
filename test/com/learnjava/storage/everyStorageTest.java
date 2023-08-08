package com.learnjava.storage;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapStorageTest.class,
        MapUUIDStorageTest.class,
        FileStorageTest.class,
        PathStorageTest.class,
        JsonPathStorageTest.class,
        XmlPathStorageTest.class
})
public class everyStorageTest {

}
