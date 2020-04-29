package com.github.akorelyakov.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class TimeDependItem {
    private final Link link;
    private final String itemHeader;
    private final String itemContent;
    private final YearMonth startDate;
    private final YearMonth endDate;


    public TimeDependItem(Link link, String itemHeader, YearMonth startDate,
                          YearMonth endDate, String itemContent) {
        Objects.requireNonNull(startDate, "startDate cant be null!");
        Objects.requireNonNull(itemHeader, "itemHeader cant be null!");
        this.link = link;
        this.itemHeader = itemHeader;
        this.startDate = startDate;
        this.endDate = endDate;
        this.itemContent = itemContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeDependItem that = (TimeDependItem) o;

        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (!itemHeader.equals(that.itemHeader)) return false;
        if (itemContent != null ? !itemContent.equals(that.itemContent) : that.itemContent != null)
            return false;
        if (!startDate.equals(that.startDate)) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = link != null ? link.hashCode() : 0;
        result = 31 * result + itemHeader.hashCode();
        result = 31 * result + (itemContent != null ? itemContent.hashCode() : 0);
        result = 31 * result + startDate.hashCode();
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TimeDependItem{" +
                "link='" + link + '\'' +
                ", itemHeader='" + itemHeader + '\'' +
                ", itemContent='" + itemContent + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}