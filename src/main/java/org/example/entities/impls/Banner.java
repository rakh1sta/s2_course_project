package org.example.entities.impls;

import org.example.entities.PrintedItem;

import java.util.Objects;

public class Banner extends PrintedItem {
    private String design;

    public Banner(Builder b_) {
        super(b_);
        this.design = b_.design;
    }

    public static class Builder extends PrintedItem.Builder<Builder, Banner> {
        private String design;

        public Builder design(String design_) {
            design = design_;
            return this;
        }

        @Override
        public Banner build() {
            return new Banner(this);
        }
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Banner banner = (Banner) o;
        return Objects.equals(design, banner.design);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), design);
    }

    @Override
    public String toString() {
        return super.toString() + ", design='" + design + "'";
    }
}
