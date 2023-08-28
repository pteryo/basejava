package com.learnjava.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final Organization EMPTY = new Organization("", "", Arrays.asList(Period.EMPTY));
    private List<Period> periods;
    private String Organization;
    private Link homePage;

    public Organization(String name, String url, List<Period> periods) {
        Organization = name;
        homePage = new Link(name, url);
        this.periods = periods;
    }

    @SuppressWarnings("unused")
    public Organization() {
    }
    @SuppressWarnings("unused")
    public List<Period> getPeriods() {
        return periods;
    }
    @SuppressWarnings("unused")
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
        //noinspection ResultOfMethodCallIgnored
        periods.forEach(period -> periodText.concat(
                ", startDate=" + period.startDate +
                        ", endDate=" + period.endDate +
                        ", title='" + period.title + "'" +
                        ", description='" + period.description + "'\n"
        )
        );

        return periodText;
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Period> getPositions() {
        return periods;
    }
}