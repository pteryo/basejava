package com.learnjava.model;

public class TextSection extends Section {
    public static final TextSection EMPTY = new TextSection("");
    private  String content;

    public TextSection(String content) {
        this.content = content;
    }
    @SuppressWarnings("unused")
    public TextSection() {
    }
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return content.equals(that.content);

    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

}