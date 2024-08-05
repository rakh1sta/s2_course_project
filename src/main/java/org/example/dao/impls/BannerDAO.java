package org.example.dao.impls;

import org.example.dao.AbstractDAO;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.Banner;
import org.example.parser.impls.BannerParser;

import java.util.Collection;

public class BannerDAO extends AbstractDAO<Banner> {
    public BannerDAO(String root) {
        super(root,"banner.csv", new BannerParser());
    }

    @Override
    public Collection<Banner> findAll(SearchCriteria<Banner> criteria) {
        return super.findAll(criteria);
    }
}
