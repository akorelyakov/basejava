/*
package com.github.akorelyakov.webapp.model;

public class ContactItem {
    private String title;
    private Link link;


    public ContactItem(Link link) {
         this.link = link;
    }

    public String contactItemContent() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public Link getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactItem that = (ContactItem) o;

        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        return link != null ? link.equals(that.link) : that.link == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactItem{" +
                "title='" + title + '\'' +
                ", link=" + link +
                '}';
    }
}
*/
