package org.example.searchingCriteria.impls;

import org.example.searchingCriteria.AbstractCriteria;
import org.example.entities.impls.Banner;

public class BannerCriteria extends AbstractCriteria<Banner> {
    @Override
    public Class<Banner> getApplianceType() {
        return Banner.class;
    }
}