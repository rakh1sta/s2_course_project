package org.example.entities.impls;

import org.example.entities.PrintedItem;

import java.util.Objects;

public class Package extends PrintedItem {
    private String content;

    public Package(Builder b_) {
        super(b_);
        this.content = b_.contents;
    }

    public static class Builder extends PrintedItem.Builder<Builder, Package> {
        private String contents;

        public Builder contents(String contents_) {
            contents = contents_;
            return this;
        }

        @Override
        public Package build() {
            return new Package(this);
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Package aPackage = (Package) o;
        return Objects.equals(content, aPackage.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
