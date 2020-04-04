import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                storage[i] = null;
                break;
            }
        }
        count = 0;
    }

    void save(Resume r) {
        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid == uuid) {
                index = i;
                break;
            }
        }
        return index == -1 ? null : storage[index];
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid == uuid) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count; i++) {
                storage[i] = storage[i + 1];
            }
            count--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    int size() {
        return count;
    }
}