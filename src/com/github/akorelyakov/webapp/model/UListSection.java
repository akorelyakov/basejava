package com.github.akorelyakov.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UListSection extends Section {
    private final List<String> listItems;

    public UListSection(List<String> listItems) {
        Objects.requireNonNull(listItems, "listItems cant be null!");
        this.listItems = listItems;
    }

    public List<String> getListItems() {
        return listItems;
    }

    @Override
    public int hashCode() {
        return listItems.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UListSection that = (UListSection) o;

        return listItems.equals(that.listItems);
    }

    @Override
    public String toString() {
        return listItems.toString();
    }
}