package org.example.parser.impls;

import org.example.entities.impls.BusinessCard;
import org.example.parser.AbstractParser;

public class BusinessCardParser extends AbstractParser<BusinessCard> {

    @Override
    protected BusinessCard parse(String[] rowData) {
        return new BusinessCard.Builder()
                .id(Long.parseLong(rowData[0]))
                .itemName(rowData[1])
                .price(Double.parseDouble(rowData[2]))
                .material(rowData[3])
                .size(rowData[4])
                .contactInfo(rowData[5])
                .build();
    }
}
