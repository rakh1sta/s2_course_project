package org.example.entities.impls;

import org.example.entities.PrintedItem;

import java.util.Objects;

public class BusinessCard extends PrintedItem {
    private String contactInfo;

    public BusinessCard(Builder b_) {
        super(b_);
        this.contactInfo = b_.contactInfo;
    }

    public static class Builder extends PrintedItem.Builder<Builder, BusinessCard> {
        private String contactInfo;

        public Builder contactInfo(String contactInfo_) {
            contactInfo = contactInfo_;
            return this;
        }

        @Override
        public BusinessCard build() {
            return new BusinessCard(this);
        }
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BusinessCard that = (BusinessCard) o;
        return Objects.equals(contactInfo, that.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contactInfo);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
