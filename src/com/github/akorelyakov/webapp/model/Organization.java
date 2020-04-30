package com.github.akorelyakov.webapp.model;

import com.github.akorelyakov.webapp.util.DateUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private List<Stage> stages;

    public Organization(String name, String url, Stage... stages) {
        this(new Link(name, url), Arrays.asList(stages));
    }

    public Organization(String name, String url, List<Stage> stages) {
        this.homePage = new Link(name, url);
        this.stages = stages;
    }

    public Organization(Link homePage, List<Stage> stages) {
        this.homePage = homePage;
        this.stages = stages;
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return stages.equals(that.stages);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + stages.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", stages=" + stages +
                '}';
    }


    public static class Stage {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String description;

        public Stage(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(DateUtil.of(startYear, startMonth), DateUtil.of(endYear, endMonth), title,
                    description);
        }

        public Stage(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(title, "title must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stage position = (Stage) o;
            return Objects.equals(startDate, position.startDate) &&
                    Objects.equals(endDate, position.endDate) &&
                    Objects.equals(title, position.title) &&
                    Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            int result = startDate != null ? startDate.hashCode() : 0;
            result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
            result = 31 * result + (title != null ? title.hashCode() : 0);
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Stage{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    '}';
        }

    }
}
