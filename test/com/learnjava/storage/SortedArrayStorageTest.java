package com.learnjava.storage;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        // если передавать ссылку на потомка в конструктор супера, происходит эксепшн
        // https://stackoverflow.com/questions/67645739/no-parameterresolver-registered-for-parameter-xxxx-in-constructor-junit5-java
        super.initSortedStorage();
    }

}