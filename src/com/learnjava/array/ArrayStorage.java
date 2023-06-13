package com.learnjava.array;

import com.learnjava.resume.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int maxCap = 10000;
    Resume[] storage = new Resume[maxCap];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size + 1 > maxCap) {
            System.out.println("ERROR in method \"save\": maximum capacity reached");
        }
        int i = findIndex(r.uuid);
        if (i < 0) {
            storage[size++] = r;
        } else {
            System.out.println("ERROR in method \"save\": " + r.uuid + " already exists");
        }
    }

    Resume get(String uuid) {
        int i = findIndex(uuid);
        if (i < 0) {
            System.out.println("ERROR in method \"update\": " + uuid + " not found");
            return null;
        }
        return storage[i];
    }

    void update(Resume r) {
        int i = findIndex(r.uuid);
        if (i < 0) {
            System.out.println("ERROR in method \"update\": " + r.uuid + " not found");
            return;
        }
        storage[i] = r;
    }

    void delete(String uuid) {
        int i = findIndex(uuid);
        if (i < 0) {
            System.out.println("ERROR in method \"delete\": " + uuid + " not found");
            return;
        }
        for (; i < size; i++) {
            storage[i] = storage[i + 1];
        }
        if (i > 0) {
            storage[size] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
