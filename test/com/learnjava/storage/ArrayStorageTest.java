package com.learnjava.storage;

public class ArrayStorageTest extends AbstractStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage(), new ArrayStorage());
        super.overflowApplicable = true;
    }

}