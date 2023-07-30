package com.learnjava.model;

import java.util.List;
import java.util.Objects;

public class ExperienceSection extends Section {
    private final List<Experience> Experiences;

    public ExperienceSection(List<Experience> Experiences) {
        Objects.requireNonNull(Experiences, "Experiences must not be null");
        this.Experiences = Experiences;
    }

    public List<Experience> getExperiences() {
        return Experiences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceSection that = (ExperienceSection) o;

        return Experiences.equals(that.Experiences);

    }

    @Override
    public int hashCode() {
        return Experiences.hashCode();
    }

    @Override
    public String toString() {
        return Experiences.toString();
    }
}