package org.example.entities.impls;

import org.example.entities.PrintedItem;

import java.util.Objects;

public class EducationalMaterial extends PrintedItem {
    private String subject;

    public EducationalMaterial(Builder b_) {
        super(b_);
        this.subject = b_.subject;
    }

    public static class Builder extends PrintedItem.Builder<Builder, EducationalMaterial> {
        private String subject;

        public Builder subject(String subject_) {
            subject = subject_;
            return this;
        }

        @Override
        public EducationalMaterial build() {
            return new EducationalMaterial(this);
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EducationalMaterial that = (EducationalMaterial) o;
        return Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
