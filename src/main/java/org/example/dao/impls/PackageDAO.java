package org.example.dao.impls;

import org.example.dao.AbstractDAO;
import org.example.searchingCriteria.SearchCriteria;
import org.example.entities.impls.Package;
import org.example.parser.impls.PackageParser;

import java.util.Collection;

public class PackageDAO extends AbstractDAO<Package> {
    public PackageDAO(String root) {
        super(root,"package.csv", new PackageParser());
    }

    @Override
    public Collection<Package> findAll(SearchCriteria<Package> criteria) {
        return super.findAll(criteria);
    }
}


