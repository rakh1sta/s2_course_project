package org.example.entities;

import java.io.Serializable;
import java.util.Objects;


public abstract class PrintedItem implements Serializable {
    private long id;
    private String itemName;
    private double price;
    private String material;
    private String size;

    public PrintedItem(Builder<? extends ObjBuilder<?>, ? extends PrintedItem> object) {
        this.id = object.id;
        this.itemName = object.itemName;
        this.price = object.price;
        this.material = object.material;
        this.size = object.size;
    }

    public static abstract class Builder<SELF extends Builder<SELF, T>, T> implements ObjBuilder<T> {
        private long id;
        private String itemName;
        private double price;
        private String material;
        private String size;

        @SuppressWarnings("unchecked")
        public SELF id(long id_) {
            id = id_;
            return (SELF) this;
        }

        @SuppressWarnings("unchecked")
        public SELF price(double price_) {
            price = price_;
            return (SELF) this;
        }

        @SuppressWarnings("unchecked")
        public SELF itemName(String itemName_) {
            itemName = itemName_;
            return (SELF) this;
        }

        @SuppressWarnings("unchecked")
        public SELF material(String material_) {
            material = material_;
            return (SELF) this;
        }

        @SuppressWarnings("unchecked")
        public SELF size(String size_) {
            size = size_;
            return (SELF) this;
        }

    }

    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintedItem that = (PrintedItem) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(itemName, that.itemName) && Objects.equals(material, that.material) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, price, material, size);
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", material='" + material + '\'' +
                ", size='" + size + '\'';
    }
}