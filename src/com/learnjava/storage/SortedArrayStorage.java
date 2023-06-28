package com.learnjava.storage;
import  com.learnjava.model.*;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillGap(int index) {
        int shiftLeft = size - ( index + 1);
        if (shiftLeft > 0) {
            System.arraycopy(storage, index + 1, storage, index, shiftLeft);
        }

    }

    @Override
    protected void putOnIndex(Resume r, int index) {
        int insertPos = -index - 1;
        int destPos = insertPos + 1;
        int length = size - insertPos;
        System.arraycopy(storage, insertPos, storage, destPos, length);
        storage[insertPos] = r;
    }
}