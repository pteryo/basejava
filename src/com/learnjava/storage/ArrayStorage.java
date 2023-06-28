package com.learnjava.storage;
import com.learnjava.model.Resume;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected void fillGap(int index) {
        storage[index] = storage[size - 1];
    }

    protected void putOnIndex(Resume r, int index) {
        storage[size] = r;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }




}