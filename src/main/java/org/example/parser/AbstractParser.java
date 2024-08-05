package org.example.parser;

import org.example.entities.PrintedItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractParser<E extends PrintedItem> implements CsvLineParser<E> {


    @Override
    public Collection<E> getData(Path fileName) {
        Collection<String> dataRow = getDataRow(fileName);
        return dataRow.stream().map(item -> parse(item.split(","))).toList();
    }

    private Collection<String> getDataRow(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            return reader.lines().skip(1).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract E parse(String[] rowData);
}
