package org.example.searchingCriteria.impls;

import org.example.searchingCriteria.AbstractCriteria;
import org.example.entities.impls.Package;

public class PackagesCriteria extends AbstractCriteria<Package> {
    @Override
    public Class<Package> getApplianceType() {
        return Package.class;
    }
}
