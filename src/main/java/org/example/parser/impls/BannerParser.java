package org.example.parser.impls;

import org.example.entities.impls.Banner;
import org.example.parser.AbstractParser;


public class BannerParser extends AbstractParser<Banner> {
    @Override
    protected Banner parse(String[] rowData) {
        return new Banner.Builder()
                .id(Long.parseLong(rowData[0]))
                .itemName(rowData[1])
                .price(Double.parseDouble(rowData[2]))
                .material(rowData[3])
                .size(rowData[4])
                .design(rowData[5])
                .build();
    }
}
