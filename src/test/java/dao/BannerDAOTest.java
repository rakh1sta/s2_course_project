package dao;

import org.example.dao.impls.BannerDAO;
import org.example.entities.PrintedItem;
import org.example.entities.impls.Banner;
import org.example.parametrs.Parameter;
import org.example.parametrs.impls.banner.DesignParameter;
import org.example.parametrs.printedItem.IdParameter;
import org.example.parametrs.printedItem.ItemNameParameter;
import org.example.parametrs.printedItem.SizeParameter;
import org.example.searchingCriteria.impls.BannerCriteria;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BannerDAOTest {
    private static BannerDAO dao;
    private static Collection<Banner> expected;

    interface ParameterExtTest<A extends PrintedItem> extends Parameter<A> {
        static <A extends PrintedItem> Parameter<A> any() {
            return appliance -> true;
        }

        static <A extends PrintedItem> Parameter<A> none() {
            return appliance -> false;
        }
    }

    @BeforeAll
    static void beforeEach() {
        dao = new BannerDAO("test");
        expected = List.of(
                new Banner.Builder()
                        .id(1)
                        .itemName("Standard Vinyl Banner")
                        .price(50.0)
                        .material("Vinyl")
                        .size("3x6ft")
                        .design("Advertising")
                        .build(),
                new Banner.Builder()
                        .id(2)
                        .itemName("Promotional Banner")
                        .price(45.0)
                        .material("Vinyl")
                        .size("4x8ft")
                        .design("Team Logo")
                        .build(),
                new Banner.Builder()
                        .id(3)
                        .itemName("Event Banner")
                        .price(60.0)
                        .material("Polyester")
                        .size("4x8ft")
                        .design("Event Name")
                        .build()
        );
    }

    @Test
    void shouldFindAll() {
        Collection<Banner> iterable = dao.findAll(new BannerCriteria().add(ParameterExtTest.any()));
        assertNotNull(iterable);
        assertTrue(expected.containsAll(iterable));
    }

    @Test
    void shouldFindNone() {
        Collection<Banner> iterable = dao.findAll(new BannerCriteria().add(ParameterExtTest.none()));

        assertNotNull(iterable);
        assertArrayEquals(new Banner[0], iterable.toArray());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Standard Vinyl Banner", "Promotional Banner", "Event Banner"})
    void shouldFindByCriteriaWithValidItemNameParameter(String itemName) {
        Collection<Banner> all = dao.findAll(new BannerCriteria().add(new ItemNameParameter<>(itemName)));

        assertNotNull(all);
        assertTrue(expected.containsAll(all));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Aslkd", "sefkjnef", "hii"})
    void shouldFindByCriteriaWithInValidItemNameParameter(String itemName) {
        Collection<Banner> all = dao.findAll(new BannerCriteria().add(new ItemNameParameter<>(itemName)));

        assertNotNull(all);
        assertTrue(all.isEmpty());
    }

    @Test
    void shouldThrowExceptionWithInValidItemNameParameter() {
        String message = assertThrows(InvalidParameterException.class,
                () -> dao.findAll(new BannerCriteria().add(new ItemNameParameter<>("")))).getMessage();

        assertNotNull(message);
        assertEquals(message, "item name can not be empty");

        String message1 = assertThrows(InvalidParameterException.class,
                () -> dao.findAll(new BannerCriteria().add(new ItemNameParameter<>(null)))).getMessage();

        assertNotNull(message1);
        assertEquals(message1, "item name can not be empty");
    }

    @ParameterizedTest
    @MethodSource("validIdList")
    void shouldFindValidId(Long id) {
        Collection<Banner> all = dao.findAll(new BannerCriteria().add(new IdParameter<>(id)));

        assertNotNull(all);
        assertEquals(all.size(), 1);
        assertNotEquals(all, expected);
        assertTrue(expected.containsAll(all));
    }

    static List<Long> validIdList() {
        return expected.stream().map(PrintedItem::getId).toList();
    }

    @ParameterizedTest
    @MethodSource("inValidIdList")
    void shouldThrowExceptionWithInValidId(Long id) {
        assertThrows(InvalidParameterException.class, () -> dao.findAll(new BannerCriteria().add(new IdParameter<>(id))));
    }

    static List<Long> inValidIdList() {
        return List.of(-1L, -2L, -3L, -4L);
    }

    @ParameterizedTest
    @MethodSource("bannerList")
    void shouldFindByMultipleParameter(Banner banner) {
        Collection<Banner> all = dao.findAll(
                new BannerCriteria()
                        .add(new SizeParameter<>(banner.getSize()))
                        .add(new DesignParameter(banner.getDesign())));

        assertNotNull(all);
        assertNotEquals(all, expected);
        assertTrue(expected.containsAll(all));
    }

    static Collection<Banner> bannerList() {
        return expected;
    }
}
