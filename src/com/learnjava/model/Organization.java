package com.learnjava.model;

import java.io.Serializable;
import java.util.List;

public class Organization implements Serializable {
    private List<Period> periods;
    private final String Organization;
    private final Link homePage;

    public Organization(String name, String url, List<Period> periods) {
        Organization = name;
        homePage = new Link(name, url);
        this.periods = periods;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPreiods(List<Period> periods) {
        this.periods = periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        com.learnjava.model.Organization that = (com.learnjava.model.Organization) o;

        if (!Organization.equals(that.Organization)) return false;
        return homePage.equals(that.homePage);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + Organization.hashCode();
        result = 31 * result + homePage.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String periodText = "\n Organization{" + Organization + ", homePage=" + homePage;
        periods.forEach(period -> periodText.concat(
                ", startDate=" + period.startDate +
                        ", endDate=" + period.endDate +
                        ", title='" + period.title + "'" +
                        ", description='" + period.description + "'\n"
        )
        );

        return periodText;
    }
}