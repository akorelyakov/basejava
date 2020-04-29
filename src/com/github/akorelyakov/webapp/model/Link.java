package com.github.akorelyakov.webapp.model;

import java.util.Objects;

public class Link {
    private final String anchor;
    private final String url;

    public Link(String anchor, String url) {
        Objects.requireNonNull(anchor, "anchor cant be null!");
        this.anchor = anchor;
        this.url = url;
    }

    public String getAnchor() {
        return anchor;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!anchor.equals(link.anchor)) return false;
        return url != null ? url.equals(link.url) : link.url == null;
    }

    @Override
    public int hashCode() {
        int result = anchor.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "anchor='" + anchor + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
