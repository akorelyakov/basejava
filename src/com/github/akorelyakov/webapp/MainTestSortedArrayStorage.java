package com.github.akorelyakov.webapp;

import com.github.akorelyakov.webapp.model.Resume;
import com.github.akorelyakov.webapp.storage.SortedArrayStorage;


public class MainTestSortedArrayStorage {
    static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1", "Alex_K");
        Resume r2 = new Resume("uuid2", "John_B");
        Resume r3 = new Resume("uuid3", "Mark_C");
        Resume r4 = new Resume("uuid3", "Andy_D");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        r3 = r4;
        ARRAY_STORAGE.update(r3);
        System.out.println("New r3 Uuid is: " + r3.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}