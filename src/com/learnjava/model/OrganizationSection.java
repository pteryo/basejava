package com.learnjava.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationSection extends Section {
    private List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "Experiences must not be null");
        this.organizations = organizations;
    }
    public OrganizationSection(Organization organization) {
        Objects.requireNonNull(organization, "Experiences must not be null");
        //noinspection ArraysAsListWithZeroOrOneArgument
        this.organizations = Arrays.asList(organization);
    }

    @SuppressWarnings("unused")
    public OrganizationSection() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organizations.equals(that.organizations);

    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        return organizations.toString();
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

}