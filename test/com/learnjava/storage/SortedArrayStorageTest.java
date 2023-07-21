package com.learnjava.storage;

public class SortedArrayStorageTest extends AbstractStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage(), new SortedArrayStorage());
        super.overflowApplicable = true;
    }

}