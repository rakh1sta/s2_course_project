package org.example.dao;

import org.example.dao.impls.BannerDAO;
import org.example.dao.impls.BusinessCardDAO;
import org.example.dao.impls.EducationMaterialDAO;
import org.example.dao.impls.PackageDAO;
import org.example.entities.PrintedItem;
import org.example.entities.impls.Banner;
import org.example.entities.impls.BusinessCard;
import org.example.entities.impls.EducationalMaterial;
import org.example.entities.impls.Package;

public enum DaoFactory {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public <A extends PrintedItem> PrintedItemDAO<A> getApplianceDAO(Class<A> applianceClass) {
        if (Banner.class.equals(applianceClass)) {
            return (PrintedItemDAO<A>) new BannerDAO("main");
        }
        if (EducationalMaterial.class.equals(applianceClass)) {
            return (PrintedItemDAO<A>) new EducationMaterialDAO("main");
        }
        if (Package.class.equals(applianceClass)) {
            return (PrintedItemDAO<A>) new PackageDAO("main");
        }

        if (BusinessCard.class.equals(applianceClass)) {
            return (PrintedItemDAO<A>) new BusinessCardDAO("main");
        }
        return null;
    }
}
