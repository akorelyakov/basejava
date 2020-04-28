package com.github.akorelyakov.webapp.model;

import java.util.List;
import java.util.Objects;

public class TimeDependSection extends Section {
    private final List<TimeDependItem> timeDependItemsList;

    public TimeDependSection(List<TimeDependItem> timeDependItemsList) {
        Objects.requireNonNull(timeDependItemsList, "timeDependItemsList list cant be null!");
        this.timeDependItemsList = timeDependItemsList;
    }

    public List<TimeDependItem> getTimeDependItemsList() {
        return timeDependItemsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeDependSection that = (TimeDependSection) o;

        return timeDependItemsList.equals(that.timeDependItemsList);
    }

    @Override
    public int hashCode() {
        return timeDependItemsList.hashCode();
    }

    @Override
    public String toString() {
        return timeDependItemsList.toString();
    }
}
