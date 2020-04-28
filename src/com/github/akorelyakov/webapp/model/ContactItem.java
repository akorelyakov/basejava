package com.github.akorelyakov.webapp.model;

import java.util.Objects;

public class ContactItem {
    private final String contactItemName;
    private String contactItemContent;

    public ContactItem(String contactItemName, String contactItemContent) {
        Objects.requireNonNull(contactItemName, "contactItemName cant be null!");
        this.contactItemContent = contactItemContent;
        this.contactItemName = contactItemName;
    }

    public String getContactItemName() {
        return contactItemName;
    }

    public String getContactItemContent() {
        return contactItemContent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactItem that = (ContactItem) o;

        if (!contactItemName.equals(that.contactItemName)) return false;
        return contactItemContent != null ? contactItemContent.equals(that.contactItemContent) : that.contactItemContent == null;
    }

    @Override
    public int hashCode() {
        int result = contactItemName.hashCode();
        result = 31 * result + (contactItemContent != null ? contactItemContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactItem{" +
                "contactItemName='" + contactItemName + '\'' +
                ", contactItemContent='" + contactItemContent + '\'' +
                '}';
    }
}
