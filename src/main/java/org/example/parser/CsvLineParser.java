package org.example.parser;

import org.example.entities.PrintedItem;

import java.nio.file.Path;
import java.util.Collection;

public interface CsvLineParser<A extends PrintedItem> {
    Collection<A> getData(Path fileName);
}
