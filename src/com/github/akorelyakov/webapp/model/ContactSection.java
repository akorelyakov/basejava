package com.github.akorelyakov.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactSection extends Section {
    List<ContactItem> contactListItems = new ArrayList<>();

    public ContactSection(List<ContactItem> contactListItems) {
        Objects.requireNonNull(contactListItems, "contactListItems cant be null!");
        this.contactListItems = contactListItems;
    }

    public List<ContactItem> getContactListItems() {
        return contactListItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactSection that = (ContactSection) o;

        return contactListItems.equals(that.contactListItems);
    }

    @Override
    public int hashCode() {
        return contactListItems.hashCode();
    }

    @Override
    public String toString() {
        return contactListItems.toString();
    }
}
