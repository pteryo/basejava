package com.learnjava.storage;

import com.learnjava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {

        if (size + 1 > STORAGE_LIMIT) {
            System.out.println("ERROR in method \"save\": maximum capacity reached");
        } else {
            int i = findIndex(r.uuid);
            if (i > 0) {
                System.out.println("ERROR in method \"save\": " + r.uuid + " already exists");
            } else {
                storage[size++] = r;
            }
        }
    }

    public Resume get(String uuid) {
        int i = findIndex(uuid);
        if (i < 0) {
            System.out.println("ERROR in method \"update\": " + uuid + " not found");
            return null;
        }
        return storage[i];
    }

    public void update(Resume resume) {
        int i = findIndex(resume.uuid);
        if (i < 0) {
            System.out.println("ERROR in method \"update\": " + resume.uuid + " not found");
            return;
        }
        storage[i] = resume;
    }

    public void delete(String uuid) {
        int i = findIndex(uuid);
        if (i < 0) {
            System.out.println("ERROR in method \"delete\": " + uuid + " not found");
            return;
        }
        storage[i] = storage[size];
        storage[size] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
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
