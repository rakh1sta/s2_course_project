package dao;

import org.example.dao.DaoFactory;
import org.example.dao.PrintedItemDAO;
import org.example.dao.impls.BannerDAO;
import org.example.entities.ObjBuilder;
import org.example.entities.PrintedItem;
import org.example.entities.impls.Banner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DAOFactoryTest {
    @Test
    void shouldReturnNullWhenUnknownClassIsPassed() {
        class Banner extends PrintedItem {
            public Banner(Builder<? extends ObjBuilder<?>, ? extends PrintedItem> object) {
                super(object);
            }
        }
        PrintedItemDAO<Banner> dao =
                DaoFactory.INSTANCE.getApplianceDAO(Banner.class);
        assertNull(dao);
    }

    @Test
    void
    shouldReturnOvenDao() {
        PrintedItemDAO<Banner> dao = DaoFactory.INSTANCE.getApplianceDAO(Banner.class);
        assertNotNull(dao);
        assertInstanceOf(BannerDAO.class, dao);
    }
}
