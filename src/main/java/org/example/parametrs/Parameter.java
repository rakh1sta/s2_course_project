package org.example.parametrs;


import org.example.entities.PrintedItem;

public interface Parameter<E extends PrintedItem> {
    boolean test(E printedItem);
}
