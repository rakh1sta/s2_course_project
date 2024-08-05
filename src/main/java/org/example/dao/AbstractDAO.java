package org.example.dao;

import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.PrintedItem;
import org.example.parser.CsvLineParser;

import java.nio.file.Path;
import java.util.Collection;

public abstract class AbstractDAO<A extends PrintedItem> implements PrintedItemDAO<A> {
    private final Path csvPath;
    private final CsvLineParser<A> parser;

    protected AbstractDAO(String root, String fileName, CsvLineParser<A> parser) {
        this.csvPath = Path.of("src/" + root + "/resources/" + fileName);
        this.parser = parser;
    }

    @Override
    public Collection<A> findAll(SearchCriteria<A> criteria) {
        return parser.getData(csvPath)
                .stream()
                .filter(criteria::test)
                .toList();
    }

    @Override
    public Collection<A> findAll() {
        return parser.getData(csvPath);
    }
}
