import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int lenght = 0;

    void clear() {
        for (int i = 0; i <= lenght; i++) {
            storage[i] = null;
        }
        lenght = 0;
    }

    void save(Resume r) {
        storage[lenght++] = r;
    }

    Resume get(String uuid) {
        int i = getPosition(uuid);
        if (i >= 0) {
            return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        int i = getPosition(uuid);
        for (; i < lenght; i++) {
            storage[i] = storage[i + 1];
        }
        if (i > 0) {
            storage[lenght] = null;
        }
        lenght--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, lenght);
    }

    int size() {
        return lenght;
    }

    private int getPosition(String uuid) {
        for (int i = 0; i < lenght; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
