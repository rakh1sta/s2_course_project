package org.example.parser.impls;

import org.example.entities.impls.Package;
import org.example.parser.AbstractParser;

public class PackageParser extends AbstractParser<Package> {
    @Override
    protected Package parse(String[] rowData) {
        return new Package.Builder()
                .id(Long.parseLong(rowData[0]))
                .itemName(rowData[1])
                .price(Double.parseDouble(rowData[2]))
                .material(rowData[3])
                .size(rowData[4])
                .contents(rowData[5])
                .build();
    }
}
